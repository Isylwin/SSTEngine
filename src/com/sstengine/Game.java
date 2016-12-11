package com.sstengine;

import com.sstengine.event.EventController;
import com.sstengine.event.EventLog;
import com.sstengine.event.events.ChangePlayerEntityTileEvent;
import com.sstengine.game.GameSettings;
import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.Player;
import com.sstengine.player.PlayerInput;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.team.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 * The Game class is the entry point into the engine.
 * Game holds all objects of the engine.
 *
 * Game should be updated at every tick of the game.
 * Game is observable so it can notify when it has reached a stopping state.
 *
 * @author Oscar de Leeuw
 */
public class Game extends Observable implements Serializable {
    private transient EventController eventController;
    private transient Random random;

    private GameSettings settings;
    private Map map;

    private List<Team> teams = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    private int elapsedTurns;
    private boolean isDone = false;

    /**
     * Creates a new Game.
     *
     * @param settings A GameSettings object that is used to define the settings of the game.
     * @param map The Map on which the Game will be played.
     * @param teams The Teams that will be playing this game.
     */
    public Game(GameSettings settings, Map map, List<Team> teams) {
        this.settings = settings;
        this.map = map;
        this.teams = teams;

        this.eventController = new EventController();
        this.random = new Random();
    }

    /**
     * Gets the map of the game.
     *
     * @return The map that is used by the game.
     */
    public Map getMap() {
        return this.map;
    }

    /**
     * Gets the game settings for this game.
     *
     * @return The settings of this game.
     */
    public GameSettings getSettings() {
        return this.settings;
    }

    /**
     * Gets all the teams in the game.
     *
     * @return A List of all the teams.
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * Gets all the players in the game.
     *
     * @return A List of all the players.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the Random object that is used by this game.
     *
     * @return The random object that is used by this game.
     */
    public Random getRandom() {
        return random;
    }

    /**
     * Gets whether the Game is done or not.
     *
     * @return True when the Game is done, false if it is not.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Adds a given Player to the game.
     * Will not add the Player if it already exists within the game.
     *
     * @param player The player that should be added to the game.
     */
    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    /**
     * Updates all the players in the game.
     * It will fetch the inputs of the players and process them.
     * Logs all events that were processed on this turn.
     * Checks whether the score and time victory conditions have been met.
     */
    public void update() {
        if (isDone) {
            return;
        }

        for (Player player : players) {
            player.update(this, eventController.getEventQueue());
            eventController.fireEventQueue(this);
            checkScore();
        }

        eventController.logGameTurn(elapsedTurns);
        elapsedTurns++;

        checkTime();
    }

    /**
     * Respawns all the PlayerEntities in the game.
     * Uses the Team of the PlayerEntity to determine where to spawn it.
     * Uses the Random object that is used by Game.
     * Fires every respawn event separately.
     */
    public void respawnAllPlayers() {
        for (Player player : players) {
            if (player.getPlayable() instanceof PlayerEntity) {
                PlayerEntity entity = (PlayerEntity) player.getPlayable();

                Tile tile = entity.getTeam().getRespawnPoint(entity, random);
                eventController.fireEvent(new ChangePlayerEntityTileEvent(entity, tile), this);
            }
        }
    }

    /**
     * Pushes the given PlayerInput to the {@link Player} with the given id.
     * Will do nothing if the given id does not match a Player.
     *
     * Might become deprecated in the near future.
     *
     * @param playerId The Id of the Player.
     * @param input The input of the Player.
     */
    public void pushInput(int playerId, PlayerInput input) {
        players.stream().filter(p -> p.getId() == playerId).findFirst().ifPresent(p -> p.pushInput(input));
    }

    /**
     * Processes a given EventLog by called the {@link EventController#fireEventLog(EventLog, Game)} method.
     *
     * @param eventLog The EventLog that should be executed on the game.
     */
    public void executeEventLog(EventLog eventLog) {
        eventController.fireEventLog(eventLog, this);
    }

    /**
     * Notifies all the observers that the current game should end.
     */
    private void stop() {
        isDone = true;
        notifyObservers();
    }

    /**
     * Checks whether the score limit has been reached.
     */
    private void checkScore() {
        if (teams.stream().anyMatch(team -> team.getScore() >= settings.getScoreLimit())) {
            stop();
        }
    }

    /**
     * Checks whether the time limit has been reached.
     */
    private void checkTime() {
        if (elapsedTurns >= settings.getTimeLimit()) {
            stop();
        }
    }
}
package com.sstengine;

import com.sstengine.event.EventController;
import com.sstengine.event.EventLog;
import com.sstengine.game.GameSettings;
import com.sstengine.map.Map;
import com.sstengine.player.Player;
import com.sstengine.player.PlayerInput;
import com.sstengine.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The Game class is the entry point into the engine.
 * Game holds all objects of the engine.
 *
 * Game should be updated at every tick of the game.
 * Game is observable so it can notify when it has reached a stopping state.
 *
 * @author Oscar de Leeuw
 */
public class Game extends Observable {
    private EventController eventController;

    private GameSettings settings;

    private Map map;

    private List<Team> teams = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    private int elapsedTurns;

    /**
     * Constructor of Game class.
     */
    public Game(GameSettings settings, Map map, List<Team> teams) {
        this.settings = settings;
        this.map = map;
        this.teams = teams;

        this.eventController = new EventController();
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
    public void update(){
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
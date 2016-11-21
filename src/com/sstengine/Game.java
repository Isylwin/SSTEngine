package com.sstengine;

import com.sstengine.event.EventController;
import com.sstengine.event.EventLog;
import com.sstengine.game.GameSettings;
import com.sstengine.map.Map;
import com.sstengine.player.Player;
import com.sstengine.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The Game class is the entry point into the engine.
 * Game holds all objects of the engine.
 *
 * Game should be updated at every tick of the game.
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
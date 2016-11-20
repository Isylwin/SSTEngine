package com.sstengine;

import com.sstengine.event.EventController;
import com.sstengine.map.Map;
import com.sstengine.player.Player;
import com.sstengine.team.Team;
import com.sstengine.util.GameSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * This class makes an instance of Game.
 *
 * @author Oscar de Leeuw
 */
public class Game {
    private static final int ENGINE_TICK_RATE = 5; //TODO Change this too a constant class.
    private GameSettings settings;

    private int scoreLimit;
    private int timeLimit;

    private List<Player> players = new ArrayList<>();

    private EventController eventController;

    private Map map;
    private Team usa;
    private Team mex;

    /**
     * Constructor of Game class.
     */
    public Game() {
        this.eventController = new EventController();

        this.scoreLimit = settings.getScoreLimit();
        this.timeLimit = settings.getTimeLimit();
        //this.map = MapLoader.getInstance().buildMap(mapName); //TODO Look into making maploader part of the engine. Maybe with the help of maploader settings.
        //usa = new Team(CountryTemp.USA, map.getUsaArea(), settings.getUsaScoringModifier()); //TODO should not be two set teams.
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
     * Checks whether the score and time victory conditions have been met.
     */
    public void update(){
        for (Player player : players) {
            player.update(this, eventController.getEventQueue());
            eventController.fireEventQueue(this);
        }

        timeLimit--;
        checkScore();
        checkTime();
    }

    /**
     * Checks whether the score limit has been reached.
     */
    private void checkScore() {
        if (mex.getScore() >= scoreLimit || usa.getScore() >= scoreLimit) {
            stop();
        }
    }

    /**
     * Checks whether the time limit has been reached.
     */
    private void checkTime() {
        if (timeLimit <= 0) {
            stop();
        }
    }

    /**
     * Stops the game.
     */
    public void stop() {

    }
}
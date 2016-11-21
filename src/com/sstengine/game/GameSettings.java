package com.sstengine.game;

/**
 * Interface for a settings object that allows access to the settings of a game.
 *
 * @author Oscar de Leeuw
 */
public interface GameSettings {
    /**
     * Gets the score limit of the game.
     *
     * @return The score limit of the game.
     */
    int getScoreLimit();

    /**
     * Sets the score limit.
     *
     * @param value The value of the new score limit.
     */
    void setScoreLimit(int value);

    /**
     * Gets the time limit of the game.
     *
     * @return The time limit of the game in ticks.
     */
    int getTimeLimit();

    /**
     * Sets the time limit.
     *
     * @param value The value of the new time limit in ticks.
     */
    void setTimeLimit(int value);
}

package com.sstengine.obstacle.staticobstacle;

/**
 * The StaticObstacleType interface is an interface that should be implemented by an enum.
 * This enum should represent the possible types of static obstacles there can be within the game.
 *
 * @author Oscar de Leeuw
 * @param <T> The Enum that implements this interface.
 */
public interface StaticObstacleType<T extends Enum> {
    /**
     * Gets the enum that implements this interface.
     *
     * @return The enum that implements this interface.
     */
    T getType();
}

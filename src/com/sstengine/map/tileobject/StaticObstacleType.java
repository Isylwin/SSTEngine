package com.sstengine.map.tileobject;

/**
 * The StaticObstacleType interface is an interface that should be implemented by an enum.
 * This enum should represent the possible types of static obstacles there can be within the game.
 *
 * @author Oscar de Leeuw
 */
public interface StaticObstacleType<T extends Enum> {
    T getType();
}

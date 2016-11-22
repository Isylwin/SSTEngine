package com.sstengine.map.obstacle.placeableobstacle;

/**
 * The PlaceableType interface is an interface that should be
 * implemented by an enum that captures all the different PlaceableTypes in your game.
 *
 * @author Oscar de Leeuw
 */
public interface PlaceableType<T extends Enum> {
    /**
     * Gets the enum that implements this interface.
     *
     * @return The enum that implements this interface.
     */
    T getType();
}

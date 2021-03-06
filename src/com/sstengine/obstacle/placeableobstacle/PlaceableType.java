package com.sstengine.obstacle.placeableobstacle;

import java.io.Serializable;

/**
 * The PlaceableType interface is an interface that should be
 * implemented by an enum that captures all the different PlaceableTypes in your game.
 *
 * @author Oscar de Leeuw
 * @param <T> The Enum that implements this interface.
 */
@FunctionalInterface
public interface PlaceableType<T extends Enum> extends Serializable {
    /**
     * Gets the enum that implements this interface.
     *
     * @return The enum that implements this interface.
     */
    T getType();
}

package com.sstengine.map.obstacle;

/**
 * The PlaceableType interface is an interface that should be
 * implemented by an enum that captures all the different PlaceableTypes in your game.
 *
 * @author Oscar de Leeuw
 */
public interface PlaceableType<T extends Enum> {
    T getType();
}

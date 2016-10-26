package com.sstengine.map.tile;

/**
 * The TileType interface is an interface that should be implemented by an enum.
 * This enum should represent the possible types of tile there can be within the game.
 *
 * @author Oscar de Leeuw
 */
public interface TileType<T extends Enum> {
    T getType();
}

package com.sstengine.mocks.enumerations;

import com.sstengine.map.tile.TileType;

/**
 * Mock implementation of the TileType class.
 *
 * @author Oscar de Leeuw
 */
public enum MockTileType implements TileType<MockTileType> {
    DIRT, GRASS, SAND;

    public MockTileType getType() {
        return this;
    }
}

package com.sstengine.map.tileobject;

import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

import java.awt.*;

/**
 * The Placeable class represents a {@link TileObject} that can be placed by
 *
 * @author Oscar de Leeuw
 */
public abstract class Placeable implements TileObject {
    private Tile tile;

    /**
     * Creates a new placeable.
     */
    protected Placeable() {
    }

    @Override
    public Point getLocation() {
        return this.tile.getLocation();
    }

    @Override
    public Tile getTile() {
        return this.tile;
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean interactWith(PlayerEntity player) {
        return false;
    }

    /**
     * Checks what the placement rules are of a placeable.
     *
     * @param east  The object that would be to the east of the placeable.
     * @param west  The object that would be to the west of the placeable.
     * @param north The object that would be to the north of the placeable.
     * @param south The object that would be to the south of the placeable.
     * @return A boolean that indicates whether the placeable can be placed.
     */
    public abstract boolean canPlaceWithNeighbours(TileObject east, TileObject west, TileObject north, TileObject south);
}

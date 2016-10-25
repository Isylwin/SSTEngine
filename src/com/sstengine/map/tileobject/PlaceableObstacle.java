package com.sstengine.map.tileobject;

import com.sstengine.drawing.Painter;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

import java.awt.*;

/**
 * The PlaceableObstacle class represents a {@link TileObject} that can be placed by
 *
 * @author Oscar de Leeuw
 */
public class PlaceableObstacle implements TileObject {
    private Tile tile;
    private PlaceableType type;

    /**
     * Creates a new placeable.
     */
    public PlaceableObstacle(PlaceableType type) {
        this.type = type;
    }

    @Override
    public Point getLocation() {
        return this.tile.getLocation();
    }

    @Override
    public boolean interactWith(PlayerEntity entity) {
        return false;
    }

    @Override
    public boolean isAccessible(PlayerEntity entity) {
        return false;
    }

    @Override
    public int getCost(PlayerEntity entity) {
        return 0;
    }

    @Override
    public Tile getTile() {
        return this.tile;
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void draw(Painter painter, Point location, int tileWidth) {

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
    /*public boolean canPlaceWithNeighbours(TileObject east, TileObject west, TileObject north, TileObject south) {

    }*/
}

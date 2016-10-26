package com.sstengine.map.tileobject;

import com.sstengine.drawing.Painter;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

import java.awt.*;

/**
 * The StaticObstacle class represents a {@link TileObject} that is static and can only be created when loading the map.
 * Obstacles are impassable by default.
 *
 * @author Oscar de Leeuw
 */
public class StaticObstacle implements TileObject {
    private Tile tile;
    private StaticObstacleType type;

    /**
     * Creates a new StaticObstacle.
     * Sets isPassable to false;
     *
     * @param type The {@link StaticObstacleType} of the StaticObstacle.
     */
    public StaticObstacle(StaticObstacleType type) {
        this.type = type;
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

    /**
     * Explicitly left empty since an obstacle does not have an interaction.
     * {@inheritDoc}
     */
    @Override
    public boolean interactWith(PlayerEntity player) {
        return false;
    }

    @Override
    public boolean isAccessible(PlayerEntity entity) {
        return false;
    }

    @Override
    public int getCost(PlayerEntity entity) {
        if (!isAccessible(entity)) {
            return -1;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Draws an obstacle with the image of it's obstacle type.
     */
    @Override
    public void draw(Painter painter, Point location, int tileWidth) {
        //painter.drawImage(ImageFinder.getInstance().getImage(type), location, tileWidth, tileWidth);
    }
}

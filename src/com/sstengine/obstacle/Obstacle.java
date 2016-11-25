package com.sstengine.obstacle;

import com.sstengine.GameObject;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.map.tile.Tile;
import com.sstengine.util.Identifiable;

import java.awt.*;

/**
 * The Obstacle class is an abstract class that defines the common behaviour between placeable and static obstacles.
 * Obstacle extends GameObject as it is a physical object.
 * Every Obstacle exists on a tile.
 *
 * @author Oscar de Leeuw
 */
public abstract class Obstacle extends GameObject implements Identifiable {
    private int id;
    private Tile tile;

    protected Obstacle(int id, PhysicalComponent physical, GraphicsComponent graphics) {
        super(physical, graphics);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the tile that this object lives on.
     *
     * @return The tile this object lives on.
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * Sets the tile that this object lives on.
     * @param tile The tile that this object should live on.
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    /**
     * Gets the location of the tile that this object lives on.
     * @return A point that represents the location of the tile.
     */
    public Point getLocation() {
        return this.tile.getLocation();
    }
}

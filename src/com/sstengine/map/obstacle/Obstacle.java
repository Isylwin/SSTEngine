package com.sstengine.map.obstacle;

import com.sstengine.GameObject;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.map.tile.Tile;

import java.awt.*;

/**
 * @author Oscar de Leeuw
 */
public abstract class Obstacle extends GameObject {
    private Tile tile;

    Obstacle(PhysicalComponent physical, GraphicsComponent graphics) {
        super(physical, graphics);
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public Point getLocation() {
        return this.tile.getLocation();
    }


}

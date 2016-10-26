package com.sstengine.map.obstacle;

import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.PhysicalComponent;

/**
 * The PlaceableObstacle class represents a {@link Obstacle} that can be placed by a {@link com.sstengine.player.leader.Leader}
 *
 * @author Oscar de Leeuw
 */
public class PlaceableObstacle extends Obstacle {
    private PlaceableType type;

    /**
     * Creates a new placeable.
     */
    public PlaceableObstacle(PhysicalComponent physical, GraphicsComponent graphicsComponent, PlaceableType type) {
        super(physical, graphicsComponent);
        this.type = type;
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

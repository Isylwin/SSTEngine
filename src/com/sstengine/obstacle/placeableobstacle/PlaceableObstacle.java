package com.sstengine.obstacle.placeableobstacle;

import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.map.tile.Tile;
import com.sstengine.obstacle.Obstacle;
import com.sstengine.strategy.PlacementStrategy;
import com.sstengine.util.enumeration.OrdinalDirection;

import java.util.Map;

/**
 * The PlaceableObstacle class represents a {@link Obstacle} that can be placed by a {@link com.sstengine.player.leader.Leader}
 *
 * @author Oscar de Leeuw
 */
public class PlaceableObstacle extends Obstacle {
    private PlaceableType type;
    private PlacementStrategy placementStrategy;

    /**
     * Creates a new PlaceableObstacle.
     *
     * @param physical The physical component of the obstacle.
     * @param graphics The graphical component of the obstacle.
     * @param strategy The placement strategy for this obstacle.
     * @param type The type of this obstacle.
     */
    public PlaceableObstacle(PhysicalComponent physical, GraphicsComponent graphics, PlacementStrategy strategy, PlaceableType type) {
        super(physical, graphics);
        this.type = type;
        this.placementStrategy = strategy;
    }

    /**
     * Gets the type of the PlaceableObstacle.
     * @return The type of the PlaceableObstacle.
     */
    public PlaceableType getType() {
        return type;
    }

    /**
     * Checks what the placement rules are of a placeable.
     *
     * @param neighbours The neighbours of this placeable.
     * @return A boolean that indicates whether the placeable can be placed.
     */
    public boolean canPlaceWithNeighbours(Map<OrdinalDirection, Tile> neighbours) {
        return placementStrategy.execute(this, neighbours);
    }
}

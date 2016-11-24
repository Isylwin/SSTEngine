package com.sstengine.player.leader;

import com.sstengine.map.tile.Tile;
import com.sstengine.obstacle.placeableobstacle.PlaceableObstacle;

/**
 * The LeaderInput class represents an single input from a {@link Leader}.
 * This consists of a placeable and the desired tile.
 *
 * @author Oscar de Leeuw
 */
public class LeaderInput {
    private PlaceableObstacle placeable;
    private Tile tile;

    /**
     * Creates a new LeaderInput object.
     *
     * @param placeable The placeable that the leader wants to place.
     * @param tile      The Tile on which the placeable should be placed.
     */
    public LeaderInput(PlaceableObstacle placeable, Tile tile) {
        this.placeable = placeable;
        this.tile = tile;
    }

    /**
     * Gets the placeable that is associated with this input.
     *
     * @return The PlaceableObstacle that is associated with this input.
     */
    public PlaceableObstacle getPlaceable() {
        return placeable;
    }

    /**
     * Gets the Tile that is associated with this input.
     *
     * @return The Tile that is associated with this input.
     */
    public Tile getTile() {
        return tile;
    }
}

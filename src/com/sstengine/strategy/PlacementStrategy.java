package com.sstengine.strategy;

import com.sstengine.map.tile.Tile;
import com.sstengine.obstacle.placeableobstacle.PlaceableObstacle;
import com.sstengine.util.enumeration.OrdinalDirection;

import java.io.Serializable;
import java.util.Map;

/**
 * The PlacementStrategy interface is an interface that defines what logic should be used for placing a PlaceableObstacle.
 *
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface PlacementStrategy extends Serializable {
    /**
     * Executes a PlacementStrategy.
     * This defines whether a placeable should be placed within the world given the tile and the neighbouring tiles.
     *
     * @param caller     The PlaceableObstacle that is being placed.
     * @param neighbours The neighbours of the PlaceableObstacle that is being placed.
     * @param tile The tile this obstacle will be placed upon.
     * @return True when the placeable can be placed, false when it cannot be placed.
     */
    boolean execute(PlaceableObstacle caller, Map<OrdinalDirection, Tile> neighbours, Tile tile);
}

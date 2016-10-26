package com.sstengine.event.events;

import com.sstengine.map.tile.Tile;
import com.sstengine.map.tileobject.StaticObstacle;

/**
 * The ChangeObstacleTileEvent is an event that changes the location of a given obstacle to a new Tile.
 * The newTile can be set to null in order to remove a StaticObstacle from the map.
 * @author Oscar de Leeuw
 */
public class ChangeObstacleTileEvent extends AbstractEvent {
    private StaticObstacle obstacle;
    private Tile newTile;
    private Tile oldTile;

    public ChangeObstacleTileEvent(StaticObstacle obstacle, Tile newTile) {
        this.obstacle = obstacle;
        this.newTile = newTile;
        this.oldTile = obstacle.getTile();
    }

    /**
     * Gets the obstacle that is involved with this event.
     *
     * @return The obstacle object.
     */
    public StaticObstacle getObstacle() {
        return obstacle;
    }

    /**
     * Gets the new tile of the obstacle.
     *
     * @return The tile the obstacle should be moved to.
     */
    public Tile getNewTile() {
        return newTile;
    }

    /**
     * Gets the tile the obstacle was at at the time of event creation.
     *
     * @return The old tile the obstacle.
     */
    public Tile getOldTile() {
        return oldTile;
    }
}

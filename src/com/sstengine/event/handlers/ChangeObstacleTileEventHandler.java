package com.sstengine.event.handlers;

import com.sstengine.Game;
import com.sstengine.event.events.ChangeObstacleTileEvent;
import com.sstengine.event.framework.Handler;
import com.sstengine.map.tile.Tile;
import com.sstengine.obstacle.Obstacle;

/**
 * The ChangeObstacleTileEventHandler class handles a ChangeObstacleTileEvent event.
 * This handler sets the Obstacle on the old tile to null and the Obstacle on the new tile to the Obstacle registered in the event.
 *
 * @author Oscar de Leeuw
 */
public class ChangeObstacleTileEventHandler implements Handler<ChangeObstacleTileEvent> {
    @Override
    public void onEvent(ChangeObstacleTileEvent event, Game game) {
        Obstacle obstacle = event.getObstacle();
        Tile oldTile = event.getOldTile();
        Tile newTile = event.getNewTile();

        oldTile.setObstacle(null);
        newTile.setObstacle(obstacle);
    }
}

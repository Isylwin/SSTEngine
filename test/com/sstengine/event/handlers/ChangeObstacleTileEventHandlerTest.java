package com.sstengine.event.handlers;

import com.sstengine.event.events.ChangeObstacleTileEvent;
import com.sstengine.map.obstacle.Obstacle;
import com.sstengine.map.obstacle.StaticObstacle;
import com.sstengine.map.tile.Tile;
import com.sstengine.mocks.MockTileType;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Oscar de Leeuw
 */
public class ChangeObstacleTileEventHandlerTest {
    private Tile tile1;
    private Tile tile2;
    private Obstacle obstacle;

    private ChangeObstacleTileEventHandler handler;
    private ChangeObstacleTileEvent event;

    @Before
    public void setUp() throws Exception {
        tile1 = new Tile(null, MockTileType.DIRT, new Point(0, 0));
        tile2 = new Tile(null, MockTileType.DIRT, new Point(1, 0));

        obstacle = new StaticObstacle(null, null);
        tile1.setObstacle(obstacle);

        assertEquals(tile1, obstacle.getTile());
        assertEquals(null, tile2.getObstacle());

        handler = new ChangeObstacleTileEventHandler();
        event = new ChangeObstacleTileEvent(obstacle, tile2);
    }

    @Test
    public void onEvent() throws Exception {
        handler.onEvent(event, null);

        assertEquals(tile2, obstacle.getTile());
        assertEquals(null, tile1.getObstacle());
    }

}
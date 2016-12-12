package com.sstengine.event.handlers;

import com.sstengine.event.events.ChangePlayerEntityTileEvent;
import com.sstengine.map.tile.Tile;
import com.sstengine.mocks.MockTileType;
import com.sstengine.player.playerentity.PlayerEntity;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Oscar de Leeuw
 */
public class ChangePlayerEntityTileEventHandlerTest {
    private Tile tile1;
    private Tile tile2;
    private PlayerEntity entity;

    private ChangePlayerEntityTileEventHandler handler;
    private ChangePlayerEntityTileEvent event;

    @Before
    public void setUp() throws Exception {
        tile1 = new Tile(1, null, MockTileType.DIRT, new Point(0, 0));
        tile2 = new Tile(2, null, MockTileType.DIRT, new Point(1, 0));

        entity = new PlayerEntity(null, null);
        tile1.setPlayerEntity(entity);

        assertEquals(tile1, entity.getTile());
        assertEquals(null, tile2.getPlayerEntity());

        handler = new ChangePlayerEntityTileEventHandler();
        event = new ChangePlayerEntityTileEvent(entity, tile2);
    }

    @Test
    public void onEvent() throws Exception {
        handler.onEvent(event, null);

        assertEquals(tile2, entity.getTile());
        assertEquals(null, tile1.getPlayerEntity());
    }

    @Test
    public void onEvent_WithNull_ReturnsNull() throws Exception {
        int asdas = 5;

        handler.onEvent(new ChangePlayerEntityTileEvent(null, tile1), null);

        assertNull(tile1.getPlayerEntity());
    }

}
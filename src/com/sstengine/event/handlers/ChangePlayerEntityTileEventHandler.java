package com.sstengine.event.handlers;

import com.sstengine.Game;
import com.sstengine.event.events.ChangePlayerEntityTileEvent;
import com.sstengine.event.framework.Handler;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

/**
 * The ChangePlayerEntityTileEventHandler class handles a ChangePlayerEntityTileEvent event.
 * This handler sets the PlayerEntity on the old tile to null and the PlayerEntity on the new tile to the PlayerEntity registered in the event.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlayerEntityTileEventHandler implements Handler<ChangePlayerEntityTileEvent> {
    @Override
    public void onEvent(ChangePlayerEntityTileEvent event, Game game) {
        Tile newTile = event.getNewTile();
        Tile oldTile = event.getOldTile();
        PlayerEntity entity = event.getPlayer();

        if (oldTile != null) {
            oldTile.setPlayerEntity(null);
        }

        if (newTile != null) {
            newTile.setPlayerEntity(entity);
        }
    }
}

package com.sstengine.event.events;

import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

/**
 * The ChangePlayerEntityTileEvent is an event that changes the tile of a given PlayerEntity to a new Tile.
 * The newTile can be set to null in order to remove a PlayerEntity from the map.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlayerEntityTileEvent extends AbstractEvent {
    private int playerId;
    private int newTileId;
    private int oldTileId;

    /**
     * Creates a new ChangePlayerEntityTileEvent.
     *
     * @param player  The PlayerEntity whose tile will be changed.
     * @param newTile The new Tile of the PlayerEntity.
     */
    public ChangePlayerEntityTileEvent(PlayerEntity player, Tile newTile) {
        this.newTileId = newTile.getId();
        this.playerId = player.getId();

        if (player != null && player.getTile() != null) {
            this.oldTileId = player.getTile().getId();
        }
    }

    /**
     * Gets the id of the PlayerEntity that is associated with this event.
     *
     * @return The id of the PlayerEntity that will be moved by this event.
     */
    public int getPlayer() {
        return playerId;
    }

    /**
     * Gets the id of the Tile that the PlayerEntity should be moved to.
     * @return The id of the Tile that the PlayerEnity will be moved to.
     */
    public int getNewTile() {
        return newTileId;
    }

    /**
     * Gets the id of the old Tile that the PlayerEntity was at at the time of event creation.
     * @return The id of the old Tile of the PlayerEntity.
     */
    public int getOldTile() {
        return oldTileId;
    }
}

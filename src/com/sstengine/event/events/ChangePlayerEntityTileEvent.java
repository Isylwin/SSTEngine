package com.sstengine.event.events;

import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.Objects;

/**
 * The ChangePlayerEntityTileEvent is an event that changes the tile of a given PlayerEntity to a new Tile.
 * The newTile can be set to null in order to remove a PlayerEntity from the map.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlayerEntityTileEvent extends AbstractEvent {
    private PlayerEntity player;
    private Tile newTile;
    private Tile oldTile;

    /**
     * Creates a new ChangePlayerEntityTileEvent.
     *
     * @param player  The PlayerEntity whose tile will be changed.
     * @param newTile The new Tile of the PlayerEntity.
     */
    public ChangePlayerEntityTileEvent(PlayerEntity player, Tile newTile) {
        Objects.requireNonNull(player, "PlayerEntity cannot be null.");

        this.player = player;
        this.newTile = newTile;
        this.oldTile = player.getTile();
    }

    /**
     * Gets the PlayerEntity that is associated with this event.
     *
     * @return The PlayerEntity that will be moved by this event.
     */
    public PlayerEntity getPlayer() {
        return player;
    }

    /**
     * Gets the Tile that the PlayerEntity should be moved to.
     * @return The Tile that the PlayerEnity will be moved to.
     */
    public Tile getNewTile() {
        return newTile;
    }

    /**
     * Gets the old Tile that the PlayerEntity was at at the time of event creation.
     * @return The old Tile of the PlayerEntity.
     */
    public Tile getOldTile() {
        return oldTile;
    }
}

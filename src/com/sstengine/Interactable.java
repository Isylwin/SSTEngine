package com.sstengine;

import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

/**
 * Interface that indicates that a Class can interact with PlayerEntities.
 * All classes that implement Interactable should be present on the map.
 *
 * @author Oscar de Leeuw
 */
public interface Interactable {
    /**
     * Handles the interaction between the interactable and a PlayerEntity.
     *
     * @param entity The PlayerEntity that is interacting with the Interactable.
     * @return True when further movement/interaction should be evaluated.
     */
    boolean interactWith(PlayerEntity entity);

    /**
     * Gets whether the given entity can move on top of this Interactable.
     *
     * @param entity The entity for which to check the accessibility.
     * @return True when the entity can enter the tile of the Interactable.
     */
    boolean isAccessible(PlayerEntity entity);

    /**
     * Gets the cost for interacting with this interactable.
     * Should return 0 when there is no additional cost.
     *
     * @param entity The entity that is going to be interacting with the interactable.
     * @return The cost of the interaction in server ticks.
     */
    int getCost(PlayerEntity entity);

    /**
     * Gets the tile on which the interactable lives.
     *
     * @return The tile the interactable lives on.
     */
    Tile getTile();

    /**
     * Sets the tile that the interactable lives on.
     *
     * @param tile The new tile the interactable lives on.
     */
    void setTile(Tile tile);
}

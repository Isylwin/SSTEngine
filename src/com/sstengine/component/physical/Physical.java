package com.sstengine.component.physical;

import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.List;

/**
 * The Physical interface is a contract for all object that exist physically within the game.
 * Every Physical object should define interaction and accessibility behaviour.
 * Most object that implement Physical should fulfill this requirement by having a {@link PhysicalComponent}.
 *
 * @author Oscar de Leeuw
 */
public interface Physical {
    /**
     * Determines whether this physical object is accessible.
     *
     * @param entity The entity that is accessing the GameObject.
     * @return True when the entity is allowed to access the GameObject.
     */
    boolean isAccessible(PlayerEntity entity);

    /**
     * Handles the interaction between a Physical object and a PlayerEntity.
     *
     * @param entity     The entity that is interacting with the GameObject.
     * @param eventQueue The queue of events to which the interaction can add events.
     */
    void interactWith(PlayerEntity entity, List<Event> eventQueue);
}

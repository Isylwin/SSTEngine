package com.sstengine.component.physical;

import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.strategy.AccessibilityStrategy;
import com.sstengine.strategy.InteractionStrategy;

import java.io.Serializable;
import java.util.List;

/**
 * The PhysicalComponent class represents the physical part of an object.
 * This defines how a physical object will react with a {@link PlayerEntity}.
 * Every physical object should define when it is accessible by a given PlayerEntity and its interaction with a PlayerEntity.
 *
 * @author Oscar de Leeuw
 */
public abstract class PhysicalComponent implements Serializable {
    private AccessibilityStrategy accessStrategy;
    private InteractionStrategy interactionStrategy;

    /**
     * Creates a new PhysicalComponent.
     *
     * @param accessStrategy      The logic that will handle the accessibility of this component.
     * @param interactionStrategy The logic that will handle the interaction between a PlayerEntity and the owner of this component.
     */
    protected PhysicalComponent(AccessibilityStrategy accessStrategy, InteractionStrategy interactionStrategy) {
        this.accessStrategy = accessStrategy;
        this.interactionStrategy = interactionStrategy;
    }

    /**
     * Determines whether this physical object is accessible.
     *
     * @param caller The Physical object upon which this method is called.
     * @param entity The entity that is accessing the GameObject.
     * @return True when the entity is allowed to access the GameObject.
     */
    public synchronized boolean isAccessible(Physical caller, PlayerEntity entity) {
        return accessStrategy.execute(caller, entity);
    }

    /**
     * Handles the interaction between a Physical object and a PlayerEntity.
     *
     * @param caller     The Physical object upon which this method is called.
     * @param entity     The entity that is interacting with the GameObject.
     * @param eventQueue The queue of events to which the interaction can add events.
     */
    public synchronized void interactWith(Physical caller, PlayerEntity entity, List<Event> eventQueue) {
        interactionStrategy.execute(caller, entity, eventQueue);
    }
}

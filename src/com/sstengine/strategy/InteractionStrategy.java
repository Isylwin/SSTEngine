package com.sstengine.strategy;

import com.sstengine.component.physical.Physical;
import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.PlayerEntity;

import java.io.Serializable;
import java.util.List;

/**
 * The InteractionStrategy interface is an interface that
 * determines the interaction strategy between a GameObject and a PlayerEntity.
 *
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface InteractionStrategy extends Serializable {
    /**
     * Determines the interaction between a PlayerEntity and a GameObject.
     * Uses the given list of events in order to queue up the {@link Event}s that are generated from the interaction.
     *
     * @param caller     The Physical object upon which this method is called.
     * @param entity     The PlayerEntity that is interacting with the GameObject.
     * @param eventQueue The queue of Events.
     */
    void execute(Physical caller, PlayerEntity entity, List<Event> eventQueue);
}

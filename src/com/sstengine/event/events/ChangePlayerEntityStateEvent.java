package com.sstengine.event.events;

import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.player.playerentity.State;

/**
 * The ChangePlayerEntityStateEvent changes the {@link State} of a PlayerEntity to the given state.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlayerEntityStateEvent extends AbstractEvent {
    private PlayerEntity player;
    private State newState;
    private State oldState;

    /**
     * Creates a new ChangePlayerEntityStateEvent.
     *
     * @param player   The PlayerEntity whose state will be changed.
     * @param newState The new State of the PlayerEntity.
     */
    public ChangePlayerEntityStateEvent(PlayerEntity player, State newState) {
        this.player = player;
        this.newState = newState;
        this.oldState = player.getState();
    }

    /**
     * Gets the PlayerEntity that is associated with this event.
     * @return The PlayerEntity that is associated with this event.
     */
    public PlayerEntity getPlayer() {
        return player;
    }

    /**
     * Gets the State that is associated with this event.
     * @return The State that is associated with this event.
     */
    public State getNewState() {
        return newState;
    }
}

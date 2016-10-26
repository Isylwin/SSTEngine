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

    public ChangePlayerEntityStateEvent(PlayerEntity player, State newState) {
        this.player = player;
        this.newState = newState;
        this.oldState = player.getState();
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public State getNewState() {
        return newState;
    }
}

package com.sstengine.event.events;

import com.sstengine.player.playerentity.PlayerEntity;

/**
 * The ChangePlayerEntityMobilityEvent changes the mobility of a PlayerEntity.
 * The amount of ticks should only be set when PlayerEntity is being immobilized.
 *
 * @deprecated Should use ChangePlayerEntityStateEvent with the ImmobilizeState.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlayerEntityMobilityEvent extends AbstractEvent {
    private PlayerEntity player;
    private boolean canPlayerMove;
    private int ticks;

    public ChangePlayerEntityMobilityEvent(PlayerEntity player, boolean canPlayerMove, int ticks) {
        this.player = player;
        this.canPlayerMove = canPlayerMove;
        this.ticks = ticks;
    }

    /**
     * Gets the PlayerEntity that is associated with this event.
     *
     * @return The PlayerEntity.
     */
    public PlayerEntity getPlayer() {
        return player;
    }

    /**
     * Gets to which state the PlayerEntity's mobility should be set.
     *
     * @return True when the PlayerEntity should be allowed to move.
     *         False when the PlayerEntity should be immobilized.
     */
    public boolean isCanPlayerMove() {
        return canPlayerMove;
    }

    /**
     * Gets the amount of ticks the PlayerEntity should be IMmobilized.
     *
     * @return The amount of ticks the PlayerEntity should be immobilized.
     */
    public int getTicks() {
        return ticks;
    }
}

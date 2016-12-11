package com.sstengine.strategy;

import com.sstengine.component.physical.Physical;
import com.sstengine.player.playerentity.PlayerEntity;

import java.io.Serializable;

/**
 * The AccessibilityStrategy interface is an interface that determines
 * whether a given PlayerEntity should be able to access a Tile with this GameObject present.
 *
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface AccessibilityStrategy extends Serializable {
    /**
     * Determines whether this GameObject is accessible to the given PlayerEntity.
     *
     * @param caller The Physical object upon which this method is called.
     * @param entity The entity that is trying to access this GameObject.
     * @return True when the entity is allowed to enter this GameObject.
     */
    boolean execute(Physical caller, PlayerEntity entity);
}

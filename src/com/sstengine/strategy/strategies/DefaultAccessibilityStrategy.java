package com.sstengine.strategy.strategies;

import com.sstengine.component.physical.Physical;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.strategy.AccessibilityStrategy;

/**
 * The DefaultAccessibilityStrategy class represents a default behaviour implementation for the
 * {@link com.sstengine.strategy.AccessibilityStrategy} interface.
 * <p>
 * This default will always return false.
 *
 * @author Oscar de Leeuw
 */
public class DefaultAccessibilityStrategy implements AccessibilityStrategy {

    @Override
    public boolean execute(Physical caller, PlayerEntity entity) {
        return false;
    }
}

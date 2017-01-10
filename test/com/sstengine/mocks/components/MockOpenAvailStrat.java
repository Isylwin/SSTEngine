package com.sstengine.mocks.components;

import com.sstengine.component.physical.Physical;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.strategy.AccessibilityStrategy;

/**
 * @author Oscar de Leeuw
 */
public class MockOpenAvailStrat implements AccessibilityStrategy {
    @Override
    public boolean execute(Physical caller, PlayerEntity entity) {
        return true;
    }
}

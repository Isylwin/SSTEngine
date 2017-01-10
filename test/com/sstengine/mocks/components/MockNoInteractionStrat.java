package com.sstengine.mocks.components;

import com.sstengine.component.physical.Physical;
import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.strategy.InteractionStrategy;

import java.util.List;

/**
 * @author Oscar de Leeuw
 */
public class MockNoInteractionStrat implements InteractionStrategy {
    @Override
    public void execute(Physical caller, PlayerEntity entity, List<Event> eventQueue) {
        //Intentionally left blank.
    }
}

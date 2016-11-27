package com.sstengine.strategy.strategies;

import com.sstengine.component.physical.Physical;
import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.strategy.InteractionStrategy;

import java.util.List;

/**
 * The DefaultInteractionStrategy class provides a default implementation of the
 * {@link com.sstengine.strategy.InteractionStrategy} interface.
 * <br>
 * This default will specify no interaction between the GameObject and PlayerEntity.
 *
 * @author Oscar de Leeuw
 */
public class DefaultInteractionStrategy implements InteractionStrategy {
    @Override
    public void execute(Physical caller, PlayerEntity entity, List<Event> eventQueue) {
        //Intentionally left blank.
    }
}

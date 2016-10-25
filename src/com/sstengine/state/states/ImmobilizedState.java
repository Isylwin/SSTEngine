package com.sstengine.state.states;

import com.sstengine.event.events.ChangePlayerEntityStateEvent;
import com.sstengine.event.framework.Event;
import com.sstengine.map.Map;
import com.sstengine.player.playerentity.MoveDirection;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.state.State;

import java.util.ArrayList;
import java.util.List;

/**
 * The ImmobilizedState represents a state where the PlayerEntity is unable to move.
 * Upon entering/creating the ImmobilizedState it should be specified how long the PlayerEntity will be immobilized.
 *
 * @author Oscar de Leeuw
 */
public class ImmobilizedState extends State {
    private int ticks;

    /**
     * Creates a new ImmobilizedState state.
     * @param ticks The amount of ticks the ImmobilizedState should last.
     */
    public ImmobilizedState(int ticks) {
        this.ticks = ticks;
    }

    @Override
    public List<Event> handleInput(PlayerEntity player, Map map, MoveDirection md) {
        List<Event> ret = new ArrayList<>();

        if(--ticks <= 0) {
            ret.add(new ChangePlayerEntityStateEvent(player, new NormalState()));
        }

        return ret;
    }
}

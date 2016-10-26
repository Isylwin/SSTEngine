package com.sstengine.event.handlers;

import com.sstengine.event.events.ChangePlayerEntityStateEvent;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.player.playerentity.State;
import com.sstengine.player.playerentity.states.ImmobilizedState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Oscar on 26-10-2016.
 */
public class ChangePlayerEntityStateEventHandlerTest {
    private State state1;
    private State state2;
    private PlayerEntity entity;

    private ChangePlayerEntityStateEventHandler handler;
    private ChangePlayerEntityStateEvent event;

    @Before
    public void setUp() throws Exception {
        state2 = new ImmobilizedState(20);

        entity = new PlayerEntity(null, null);
        state1 = entity.getState();

        assertEquals(state1, entity.getState());

        handler = new ChangePlayerEntityStateEventHandler();
        event = new ChangePlayerEntityStateEvent(entity, state2);
    }

    @Test
    public void onEvent() throws Exception {
        handler.onEvent(event, null);

        assertEquals(state2, entity.getState());
        assertNotEquals(state1, entity.getState());
    }

}
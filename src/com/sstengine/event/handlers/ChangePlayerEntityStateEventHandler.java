package com.sstengine.event.handlers;

import com.sstengine.Game;
import com.sstengine.event.events.ChangePlayerEntityStateEvent;
import com.sstengine.event.framework.Handler;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.player.playerentity.State;

/**
 * The ChangePlayerEntityStateEventHandler class handles a ChangePlayerEntityStateEvent.
 * It sets the state of the PlayerEntity in the event to the supplied State in the event.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlayerEntityStateEventHandler implements Handler<ChangePlayerEntityStateEvent> {
    @Override
    public void onEvent(ChangePlayerEntityStateEvent event, Game game) {
        PlayerEntity entity = event.getPlayer();
        State state = event.getNewState();

        entity.setState(state);
    }
}

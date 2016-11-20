package com.sstengine.event;


import com.sstengine.Game;
import com.sstengine.event.events.ChangeObstacleTileEvent;
import com.sstengine.event.events.ChangePlayerEntityStateEvent;
import com.sstengine.event.events.ChangePlayerEntityTileEvent;
import com.sstengine.event.framework.Event;
import com.sstengine.event.framework.EventDispatcher;
import com.sstengine.event.handlers.ChangeObstacleTileEventHandler;
import com.sstengine.event.handlers.ChangePlayerEntityStateEventHandler;
import com.sstengine.event.handlers.ChangePlayerEntityTileEventHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * The EventController is a class that controls the event system within the game.
 *
 * @author Oscar de Leeuw
 */
public class EventController {
    private EventDispatcher dispatcher;
    private List<Event> eventQueue;

    public EventController() {
        this.eventQueue = new ArrayList<>();
        this.dispatcher = new EventDispatcher();
        registerAllEvents();
    }

    /**
     * Gets a log of fired events.
     *
     * @return A list of all the events that have been fired.
     */
    public List<Event> getEventQueue() {
        return eventQueue;
    }

    /**
     * Registers all the events with their corresponding eventHandler.
     */
    protected void registerAllEvents() {
        dispatcher.registerHandler(ChangeObstacleTileEvent.class, new ChangeObstacleTileEventHandler());
        dispatcher.registerHandler(ChangePlayerEntityTileEvent.class, new ChangePlayerEntityTileEventHandler());
        dispatcher.registerHandler(ChangePlayerEntityStateEvent.class, new ChangePlayerEntityStateEventHandler());
    }

    /**
     * Fires a given event.
     * Requires the game for handling the event.
     *
     * @param event The event that should be fired.
     * @param game The game on which the eventHandler can execute the event.
     */
    public void fireEvent(Event event, Game game) {
        dispatcher.dispatch(event, game);
    }

    /**
     * Fires all the events in the eventQueue.
     * Requires the game for handling events.
     * Clears the eventQueue after firing all events.
     *
     * @param game The game of which the eventHandler can execute the event.
     */
    public void fireEventQueue(Game game) {
        for (Event event : eventQueue) {
            fireEvent(event, game);
        }

        eventQueue.clear();
    }
}

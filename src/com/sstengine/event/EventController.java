package com.sstengine.event;


import com.sstengine.Game;
import com.sstengine.event.events.*;
import com.sstengine.event.framework.Event;
import com.sstengine.event.framework.EventDispatcher;
import com.sstengine.event.handlers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The EventController is a class that controls the event system within the game.
 *
 * @author Oscar de Leeuw
 */
public class EventController {
    private EventDispatcher dispatcher;
    private List<Event> eventQueue;
    private List<Event> eventCache;
    private Map<Integer, EventLog> loggedGameTurns;

    /**
     * Creates a new EventController.
     */
    public EventController() {
        this.eventQueue = new ArrayList<>();
        this.dispatcher = new EventDispatcher();
        this.eventCache = new ArrayList<>();
        this.loggedGameTurns = new HashMap<>();
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
        dispatcher.registerHandler(ChangeTeamScoreEvent.class, new ChangeTeamScoreEventHandler());
        dispatcher.registerHandler(ChangePlaceableCount.class, new ChangePlaceableCountHandler());
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
     *
     * Caches every event it fires.
     * Clears the eventQueue after firing all events.
     *
     * @param game The game on which the eventHandler can execute the event.
     */
    public void fireEventQueue(Game game) {
        for (Event event : eventQueue) {
            fireEvent(event, game);
            cacheEvent(event);
        }

        eventQueue.clear();
    }

    /**
     * Fires all events in a given EventLog.
     *
     * @param log  The EventLog whose Events need to be fired.
     * @param game The game on which the eventHandler can execute the event.
     */
    public void fireEventLog(EventLog log, Game game) {
        for (Event event : log.getEvents()) {
            fireEvent(event, game);
        }
    }

    /**
     * Saves the current cache of events to an {@link EventLog} under the given id.
     * Clears the eventCache after saving.
     *
     * @param turnId The id under which to save the EventLog.
     */
    public void logGameTurn(int turnId) {
        loggedGameTurns.put(turnId, new EventLog(eventCache, turnId));
        eventCache.clear();
    }

    /**
     * Gets the EventLog of a given turn.
     * Will return null if the requested turn does not have an EventLog.
     *
     * @param turnId The turn for which to look up the EventLog.
     * @return The EventLog of the given turn.
     */
    public EventLog getGameTurnLog(int turnId) {
        return loggedGameTurns.get(turnId);
    }

    /**
     * Caches the given event.
     *
     * @param event The event to cache.
     */
    private void cacheEvent(Event event) {
        eventCache.add(event);
    }
}

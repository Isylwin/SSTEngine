package com.sstengine.event;

import com.sstengine.event.framework.Event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The EventLog class holds an log of events.
 * Every EventLog has an Id.
 *
 * @author Oscar de Leeuw
 */
public class EventLog implements Serializable {
    private List<Event> events;
    private int id;

    /**
     * Creates a new EventLog.
     *
     * @param id The id of the EventLog.
     */
    public EventLog(int id) {
        this(new ArrayList<>(), id);
    }

    /**
     * Creates a new EventLog.
     * @param events A list of events that should be logged by this EventLog.
     * @param id The id of the EventLog.
     */
    public EventLog(List<Event> events, int id) {
        this.events = new ArrayList<>(events);
        this.id = id;
    }

    /**
     * Gets the Id of the EventLog.
     *
     * @return The Id of the EventLog.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Adds a single event to the EventLog.
     *
     * @param event The event that should be added to the log.
     */
    public void addEvent(Event event) {
        this.events.add(event);
    }

    /**
     * Adds multiple events to the EventLog.
     *
     * @param events The events that should be added to the log.
     */
    public void addEvents(List<Event> events) {
        this.events.addAll(events);
    }

    /**
     * Gets all the events in the EventLog.
     *
     * @return A list of all events that were logged in the EventLog.
     */
    public List<Event> getEvents() {
        return this.events;
    }
}

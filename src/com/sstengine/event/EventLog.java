package com.sstengine.event;

import com.sstengine.event.framework.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oscar de Leeuw
 */
public class EventLog {
    private List<Event> events;
    private int id;

    public EventLog(int id) {
        this(new ArrayList<>(), id);
    }

    public EventLog(List<Event> events, int id) {
        this.events = new ArrayList<>(events);
        this.id = id;
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

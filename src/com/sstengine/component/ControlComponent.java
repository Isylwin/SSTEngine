package com.sstengine.component;

import com.sstengine.Game;
import com.sstengine.event.framework.Event;

import java.util.List;

/**
 * @author Oscar de Leeuw
 */
public abstract class ControlComponent {
    public abstract void update(Object caller, Game game, List<Event> eventQueue);
}

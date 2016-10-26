package com.sstengine.player.leader;

import com.sstengine.Game;
import com.sstengine.event.framework.Event;

import java.util.List;

/**
 *  @author Oscar de Leeuw
 */
public class Leader {
    private PlaceableManager manager;

    /**
     * Creates a new Leader object with the given name.
     *
     * @param manager The PlaceableManager of this leader.
     */
    public Leader(PlaceableManager manager) {
        this.manager = manager;
    }


    public void update(Game game, List<Event> eventQueue) {
        manager.update();
    }


}

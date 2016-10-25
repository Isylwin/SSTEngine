package com.sstengine.player.leader;

import com.sstengine.Game;
import com.sstengine.GameSettings;
import com.sstengine.Team;
import com.sstengine.event.framework.*;
import com.sstengine.event.framework.Event;
import com.sstengine.map.tileobject.PlaceableObstacle;
import com.sstengine.player.Player;
import com.sstengine.player.playerentity.MoveDirection;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *  Represents the Leader player object.
 *  Extends the {@link Player} class.
 *
 *  @author Oscar de Leeuw
 */
public class Leader extends Player {
    private PlaceableManager manager;

    /**
     * Creates a new Leader object with the given name.
     * Calls the {@link Player#Player(String, Team)} constructor.
     *
     * @param name The name of the player.
     * @param team The team this player is part of.
     * @param manager The PlaceableManager of this leader.
     */
    public Leader(String name, Team team, PlaceableManager manager) {
        super(name, team);
        this.manager = manager;


    }

    @Override
    public void update(Game game, List<Event> eventQueue) {
        manager.update();
    }


}

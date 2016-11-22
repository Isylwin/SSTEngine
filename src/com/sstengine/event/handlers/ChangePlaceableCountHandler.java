package com.sstengine.event.handlers;

import com.sstengine.Game;
import com.sstengine.event.events.ChangePlaceableCount;
import com.sstengine.event.framework.Handler;
import com.sstengine.map.obstacle.placeableobstacle.PlaceableType;
import com.sstengine.player.leader.Leader;
import com.sstengine.player.leader.PlaceableManager;

/**
 * The ChangePlaceableCountHandler class handles a ChangePlaceableCount event.
 * It fetches the manager from the leader and changes the amount of the given placeable with the given amount.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlaceableCountHandler implements Handler<ChangePlaceableCount> {
    @Override
    public void onEvent(ChangePlaceableCount event, Game game) {
        Leader leader = event.getLeader();
        PlaceableManager manager = leader.getManager();

        PlaceableType type = event.getPlaceableType();
        int change = event.getAmount();

        manager.increasePlaceableCount(type, change);
    }
}

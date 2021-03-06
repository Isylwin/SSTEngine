package com.sstengine.player.playerentity.states;

import com.sstengine.event.events.ChangePlayerEntityTileEvent;
import com.sstengine.event.framework.Event;
import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.MoveDirection;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.player.playerentity.State;

import java.awt.*;
import java.util.List;

/**
 * The default state of every PlayerEntity.
 * In this state movement is handled normally.
 *
 * @author Oscar de Leeuw
 */
public class NormalState implements State {

    @Override
    public void handleInput(PlayerEntity player, MoveDirection nextMove, Map map, List<Event> eventQueue) {
        Point currentLocation = player.getLocation();

        Tile nextTile = map.getTile(nextMove.getLocationWithMove(currentLocation));

        if(nextTile.isAccessible(player)) {
            eventQueue.add(new ChangePlayerEntityTileEvent(player, nextTile));
        }

        nextTile.interactWithGameObjects(player, eventQueue);
    }
}

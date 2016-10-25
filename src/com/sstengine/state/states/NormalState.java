package com.sstengine.state.states;

import com.sstengine.event.events.ChangePlayerEntityTileEvent;
import com.sstengine.event.framework.Event;
import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.MoveDirection;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.state.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The default state of every PlayerEntity.
 * In this state movement is handled normally.
 *
 * @author Oscar de Leeuw
 */
public class NormalState extends State {

    @Override
    public List<Event> handleInput(PlayerEntity player, Map map, MoveDirection md) {
        List<Event> ret = new ArrayList<>();

        Point currentLocation = player.getLocation();
        Tile nextTile = map.getTile(currentLocation);

        if(nextTile.isAccessible(player)) {
            ret.add(new ChangePlayerEntityTileEvent(player, nextTile));
        }

        //TODO Handle interactions.
        return ret;
    }
}

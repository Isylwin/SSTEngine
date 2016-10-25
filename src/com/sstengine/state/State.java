package com.sstengine.state;

import com.sstengine.event.framework.Event;
import com.sstengine.map.Map;
import com.sstengine.player.playerentity.MoveDirection;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.List;

/**
 * The State class represents the current state of a PlayerEntity.
 * The State determines what should happen with the next input of the PlayerEntity.
 *
 * @author Oscar de Leeuw
 */
public abstract class State {
    /**
     * Handles input from a playerEntity according to the current state of the entity.
     *
     * @param player The playerEntity for which to process input.
     * @param map The map of the game.
     * @param md The move that should be processed.
     * @return A list of events that should be executed on the game.
     */
    public abstract List<Event> handleInput(PlayerEntity player, Map map, MoveDirection md);
}

package com.sstengine.player.playerentity;

import com.sstengine.event.framework.Event;
import com.sstengine.map.Map;

import java.io.Serializable;
import java.util.List;

/**
 * The State interface represents the current state of a PlayerEntity.
 * The State determines what should happen with the next input of the PlayerEntity.
 *
 * @author Oscar de Leeuw
 */
public interface State extends Serializable {
    /**
     * Handles input from a playerEntity according to the current state of the entity.
     *
     * @param player The playerEntity for which to process input.
     * @param nextMove The MoveDirection in which the PlayerEntity wants to move.
     * @param map The map of the game.
     * @param eventQueue The queue of events that will be executed by the game.
     */
    void handleInput(PlayerEntity player, MoveDirection nextMove, Map map, List<Event> eventQueue);
}

package com.sstengine.computer;


import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.Deque;

/**
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface PathingAlgorithm {
    /**
     * Calculates a path through a given map.
     * Returns a Deque object that should be used as a stack.
     * Path excludes the start. Path includes the goal.
     *
     * @param map   The map that should be traversed.
     * @param entity The entity for which to calculate a path.
     * @param start The starting tile of the algorithm.
     * @param end   The goal tile of the algorithm.
     * @return A Deque with the path in a FIFO order.
     */
    Deque<Tile> calculatePath(Map map, PlayerEntity entity, Tile start, Tile end);
}

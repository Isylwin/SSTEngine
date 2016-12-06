package com.sstengine.computer;


import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.Deque;

/**
 * @author Oscar de Leeuw
 */
class Path {
    private PathingAlgorithm algorithm;
    private Deque<Tile> pathDeque;
    private int age;

    /**
     * Creates a new Path object with the given algorithm.
     *
     * @param algorithm The pathing algorithm that should be used for pathing.
     */
    Path(PathingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Gets the next location on the pathDeque.
     * Increases the age of the pathDeque by 1.
     *
     * @return The next tile in the pathDeque.
     */
    Tile getNextLocation() {
        return pathDeque != null ? pathDeque.pollFirst() : null;
    }

    /**
     * Gets, but doesn't remove, the goal of the pathDeque.
     *
     * @return The endpoint of the pathDeque.
     */
    Tile getEndTile() {
        return pathDeque != null ? pathDeque.peekLast() : null;
    }

    /**
     * Gets the size of the pathDeque.
     *
     * @return The amount of tiles in the pathDeque.
     */
    int size() {
        return this.pathDeque.size();
    }

    /**
     * Returns the age of the pathDeque.
     *
     * @return The age of the pathDeque in server ticks.
     */
    int getAge() {
        return this.age;
    }

    /**
     * Increases the age of the tile.
     */
    void age() {
        this.age++;
    }

    /**
     * Checks whether a given tile is present in the pathDeque.
     *
     * @param tile The point to check for.
     * @return True when the point is present in the pathDeque.
     */
    public boolean contains(Tile tile) {
        return pathDeque.contains(tile);
    }

    /**
     * Calculates a new pathDeque to the given goal.
     * Path excludes the start. Path includes the goal.
     * Resets the age of the pathDeque.
     *
     * @param start The starting location of the pathDeque. Generally the current location of the entity.
     * @param goal  The end of the pathDeque. Generally the goal of the entity.
     * @param map   The map on which the pathDeque should be calculated.
     * @param entity The entity for which to calculate a pathDeque.
     */
    void calculateNewPath(Tile start, Tile goal, Map map, PlayerEntity entity) {
        this.pathDeque = algorithm.calculatePath(map, entity, start, goal);
        age = 0;
    }

    /**
     * Connects a given start to the current pathDeque.
     * Polls the first element to make place for the goal from the new calculation.
     *
     * @param start The new start of the pathDeque.
     * @param map   The map on which the pathDeque should be calculated.
     * @param entity The entity for which to calculate a pathDeque.
     */
    void precedePath(Tile start, Map map, PlayerEntity entity) {
        //Must poll since the goal is going to be added to the map again.
        Tile goal = pathDeque.pollFirst();
        //Calculate a new pathDeque.
        Deque<Tile> extraPath = algorithm.calculatePath(map, entity, start, goal);
        age += extraPath.size();

        //ExtraPath will be reduced in size every iteration.
        int size = extraPath.size();
        //Adds the extraPath in correct order on top of the pathDeque.
        for (int i = 0; i < size; i++) {
            //Get the last point in the extra pathDeque.
            Tile point = extraPath.pollLast();
            //Push it to the top of the current pathDeque.
            pathDeque.offerFirst(point);
        }
    }

    /**
     * Extends the pathDeque to a new goal.
     * Will remove an amount of tiles equal to the age of the pathDeque before recalculating the pathDeque in order to guaranteed the best pathDeque.
     *
     * @param start The current location of the entity, might be needed if the pathDeque is too old.
     * @param goal The goal of the extension.
     * @param map  The map on which the pathDeque should be calculated.
     * @param entity The entity for which to calculate a pathDeque.
     */
    void extendPath(Tile start, Tile goal, Map map, PlayerEntity entity) {
        //If the pathDeque is too old anyway calculate a new pathDeque.
        if (age >= pathDeque.size()) {
            calculateNewPath(start, goal, map, entity);
            return;
        }

        for (int i = 0; i < age; i++) {
            pathDeque.pollLast();
        }
        Tile endOfOldPath = pathDeque.peekLast();
        Deque<Tile> extraPath = algorithm.calculatePath(map, entity, endOfOldPath, goal);

        //ExtraPath will be reduced in size every iteration.
        int size = extraPath.size();
        //Adds the extraPath in correct order at the bottom of the pathDeque.
        for (int i = 0; i < size; i++) {
            //Get the first point in the extra pathDeque.
            Tile point = extraPath.pollFirst();
            //Push it to the end of the pathDeque.
            pathDeque.offerLast(point);
        }
    }
}

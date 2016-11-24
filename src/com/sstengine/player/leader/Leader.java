package com.sstengine.player.leader;

import com.sstengine.Game;
import com.sstengine.event.events.ChangeObstacleTileEvent;
import com.sstengine.event.events.ChangePlaceableCount;
import com.sstengine.event.framework.Event;
import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.obstacle.placeableobstacle.PlaceableObstacle;
import com.sstengine.obstacle.placeableobstacle.PlaceableType;
import com.sstengine.util.enumeration.OrdinalDirection;

import java.util.List;

/**
 * The Leader represents a leader of a team. The Leader is not physically in the game.
 * Leader can place placeables within the game.
 *
 *  @author Oscar de Leeuw
 */
public class Leader {
    private PlaceableManager manager;
    private List<LeaderInput> inputs;

    /**
     * Creates a new Leader object with the given name.
     *
     * @param manager The PlaceableManager of this leader.
     */
    public Leader(PlaceableManager manager) {
        this.manager = manager;
    }

    /**
     * Gets the PlaceableManager of the leader.
     *
     * @return The PlaceableManager of the leader.
     */
    public PlaceableManager getManager() {
        return manager;
    }

    /**
     * Pushes input to the Leader.
     *
     * @param input The input that should be pushed to the Leader.
     */
    public void pushInput(LeaderInput input) {
        inputs.add(input);
    }

    /**
     * Updates the Leader.
     * Will first update the PlaceableManager counters and then process inputs.
     *
     * @param game       The game which can be used for logic.
     * @param eventQueue A list of events to which events can be added.
     */
    public void update(Game game, List<Event> eventQueue) {
        createPlaceableEvents(manager.getUpdatedPlaceables(), game, eventQueue);
        processInputs(game, eventQueue);
    }

    private void createPlaceableEvents(List<PlaceableType> types, Game game, List<Event> eventQueue) {
        for (PlaceableType type : types) {
            eventQueue.add(new ChangePlaceableCount(this, type, 1));
        }
    }

    private void processInputs(Game game, List<Event> eventQueue) {
        Map map = game.getMap();

        for (LeaderInput input : inputs) {
            PlaceableObstacle obstacle = input.getPlaceable();
            Tile tile = input.getTile();

            java.util.Map<OrdinalDirection, Tile> neighbours = map.getOrdinalNeighbours(tile);

            if (manager.canPlace(obstacle.getType()) && obstacle.canPlaceWithNeighbours(neighbours)) {
                eventQueue.add(new ChangeObstacleTileEvent(obstacle, tile));
                eventQueue.add(new ChangePlaceableCount(this, obstacle.getType(), -1));
            }
        }
    }
}

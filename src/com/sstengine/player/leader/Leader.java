package com.sstengine.player.leader;

import com.sstengine.Game;
import com.sstengine.event.events.ChangeObstacleTileEvent;
import com.sstengine.event.events.ChangePlaceableCount;
import com.sstengine.event.framework.Event;
import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.obstacle.placeableobstacle.PlaceableObstacle;
import com.sstengine.obstacle.placeableobstacle.PlaceableType;
import com.sstengine.player.Playable;
import com.sstengine.player.Player;
import com.sstengine.player.PlayerInput;
import com.sstengine.util.enumeration.OrdinalDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * The Leader represents a leader of a team. The Leader is not physically in the game.
 * Leader can place placeables within the game.
 *
 *  @author Oscar de Leeuw
 */
public class Leader implements Playable {
    private Player player;

    private PlaceableManager manager;
    private List<LeaderInput> inputs;

    /**
     * Creates a new Leader object with the given name.
     *
     * @param manager The PlaceableManager of this Leader.
     */
    public Leader(PlaceableManager manager) {
        this.manager = manager;
        this.inputs = new ArrayList<>();
    }

    @Override
    public int getId() {
        return player.getId();
    }

    /**
     * Gets the PlaceableManager of the leader.
     *
     * @return The PlaceableManager of the leader.
     */
    public PlaceableManager getManager() {
        return manager;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void pushInput(PlayerInput input) {
        if (input instanceof LeaderInput) {
            inputs.add((LeaderInput) input);
        } else {
            throw new IllegalArgumentException("Input should be of the LeaderInput class.");
        }
    }

    /**
     * {@inheritDoc}
     *
     * Will first update the PlaceableManager counters with the {@link Leader#createPlaceableEvents(List, Game, List)} method
     * and then process inputs with the {@link Leader#processInputs(Game, List)} method.
     */
    @Override
    public void update(Game game, List<Event> eventQueue) {
        createPlaceableEvents(manager.getUpdatedPlaceables(), game, eventQueue);
        processInputs(game, eventQueue);
    }

    /**
     * Creates {@link ChangePlaceableCount} events for all the PlaceableTypes who's count need to be updated.
     * Increments all counts of the given list of types by 1.
     *
     * @param types      A list of the PlaceableTypes that should be updated.
     * @param game       The game which can be used for logic.
     * @param eventQueue A list of events to which events can be added.
     */
    protected void createPlaceableEvents(List<PlaceableType> types, Game game, List<Event> eventQueue) {
        for (PlaceableType type : types) {
            eventQueue.add(new ChangePlaceableCount(this, type, 1));
        }
    }

    /**
     * Processes all the input that was given to this Leader on a single turn.
     *
     * @param game       The game which can be used for logic.
     * @param eventQueue A list of events to which events can be added.
     */
    protected void processInputs(Game game, List<Event> eventQueue) {
        Map map = game.getMap();

        for (LeaderInput input : inputs) {
            PlaceableObstacle obstacle = input.getPlaceable();
            Tile tile = input.getTile();

            java.util.Map<OrdinalDirection, Tile> neighbours = map.getOrdinalNeighbours(tile);

            if (manager.canPlace(obstacle.getType()) && obstacle.canPlaceWithNeighbours(tile, neighbours)) {
                eventQueue.add(new ChangeObstacleTileEvent(obstacle, tile));
                eventQueue.add(new ChangePlaceableCount(this, obstacle.getType(), -1));
            }
        }
    }
}

package com.sstengine.event.events;

import com.sstengine.obstacle.placeableobstacle.PlaceableType;
import com.sstengine.player.leader.Leader;

import java.util.Objects;

/**
 * The ChangePlaceableCount event changes the count of a given type by the given amount for the given leader.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlaceableCount extends AbstractEvent {
    private int leaderId;
    private PlaceableType type;
    private int amount;

    /**
     * Creates a new ChangePlaceableCount event.
     *
     * @param leader The leader of which the placeable count should be changed.
     * @param type   The type of the placeable of which the count should be changed.
     * @param amount The amount of change.
     */
    public ChangePlaceableCount(Leader leader, PlaceableType type, int amount) {
        Objects.requireNonNull(leader, "Leader cannot be null.");
        Objects.requireNonNull(type, "type cannot be null.");

        this.leaderId = leader.getId();
        this.type = type;
        this.amount = amount;
    }

    /**
     * Gets the id of the Leader that is associated with this event.
     *
     * @return The id of the Leader that is associated with this event.
     */
    public int getLeader() {
        return leaderId;
    }

    /**
     * Gets the PlaceableType that is associated with this event.
     *
     * @return The PlaceableType that is associated with this event.
     */
    public PlaceableType getPlaceableType() {
        return type;
    }

    /**
     * Gets the amount the count should be changed by.
     *
     * @return The amount of change.
     */
    public int getAmount() {
        return amount;
    }
}

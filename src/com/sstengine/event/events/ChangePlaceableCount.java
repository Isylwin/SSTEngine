package com.sstengine.event.events;

import com.sstengine.obstacle.placeableobstacle.PlaceableType;
import com.sstengine.player.leader.Leader;

/**
 * The ChangePlaceableCount event changes the count of a given type by the given amount for the given leader.
 *
 * @author Oscar de Leeuw
 */
public class ChangePlaceableCount extends AbstractEvent {
    private Leader leader;
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
        this.leader = leader;
        this.type = type;
        this.amount = amount;
    }

    /**
     * Gets the Leader that is associated with this event.
     *
     * @return The leader that is associated with this event.
     */
    public Leader getLeader() {
        return leader;
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

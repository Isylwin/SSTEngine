package com.sstengine.player.leader;

import com.sstengine.event.events.ChangePlaceableCount;

/**
 * The PlaceableCounter class records placement data of a single placeableType.
 * This class should be managed by a manager.
 * The placeable has a certain amount. This captures how many of this type the leader can place at the current moment.
 * The placeable has a tick threshold. After an amount of ticks equal to the tick threshold the amount is increased by one through an {@link ChangePlaceableCount} event.
 * This class should be queried at every tick of the server.
 *
 * @author Oscar de Leeuw
 */
public class PlaceableCounter {
    private int amount;
    private int tickThreshold;
    private int currentTick;

    /**
     * Creates a new PlaceableCounter object.
     *
     * @param amount The amount of the placeable that the leader starts off with.
     * @param tickThreshold The threshold for the amount of ticks it takes to increase the amount by one.
     */
    public PlaceableCounter(int amount, int tickThreshold) {
        this.amount = amount;
        this.tickThreshold = tickThreshold;
        this.currentTick = 0;
    }

    /**
     * Gets the amount of Placeable can be placed of this PlaceableType.
     * @return The amount of placeables.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Gets the threshold for the amount of ticks needed to increase the amount by one.
     * @return The tick threshold.
     */
    public int getTickThreshold() {
        return tickThreshold;
    }

    /**
     * Gets the current amount of ticks.
     * @return The current amount of ticks.
     */
    public int getCurrentTick() {
        return currentTick;
    }

    /**
     * Gets whether this PlaceableType can be placed.
     * @return True when the PlaceableType can be placed.
     */
    public boolean canPlace() {
        return amount > 0;
    }

    /**
     * Updates the placeable.
     * If the amount of ticks surpasses the tick threshold it will return true.
     *
     * @return True if the PlaceableType that is associated with this counter should be increased.
     */
    public boolean update() {
        if(++currentTick >= tickThreshold) {
            currentTick = 0;
            return true;
        }
        return false;
    }

    /**
     * Increases the amount by the given integer.
     * @param change The amount of change to increase by.
     */
    public void increaseAmount(int change) {
        amount += change;
    }
}

package com.sstengine.player.leader;

import com.sstengine.obstacle.placeableobstacle.PlaceableType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The PlaceableManager class manages all the placeables that a leader could place.
 * The class records a Map of {@link PlaceableType} and {@link PlaceableCounter}.
 * This Map should be populated by extending this class.
 *
 * @author Oscar de Leeuw
 */
public class PlaceableManager implements Serializable {
    private Map<PlaceableType, PlaceableCounter> placeableTable;
    private List<PlaceableType> updatedPlaceables;

    /**
     * Creates a new PlaceableManager.
     */
    public PlaceableManager() {
        this.placeableTable = new HashMap<>();
        this.updatedPlaceables = new ArrayList<>();
    }

    /**
     * Gets all the PlaceableTypes that this manager manages.
     * @return A list of all the PlaceableTypes.
     */
    public List<PlaceableType> getPlaceableTypes() {
        List<PlaceableType> ret = new ArrayList<>();

        for (PlaceableType type : placeableTable.keySet()) {
            ret.add(type);
        }

        return ret;
    }

    /**
     * Registers a given PlaceableType with the given counter to the manager.
     *
     * @param type    The type of placeable that this manager should manage.
     * @param counter The counter used to manage the given placeable.
     */
    public void registerPlaceableType(PlaceableType type, PlaceableCounter counter) {
        placeableTable.put(type, counter);
    }

    /**
     * Gets all the placeables that should be increased in amount.
     * This method cannot add events to the eventQueue directly since creating the events requires the Leader object.
     * @return A list of the PlaceableTypes that should be increased in amount.
     */
    public List<PlaceableType> getUpdatedPlaceables() {
        updatedPlaceables.clear();

        for (PlaceableType type : placeableTable.keySet()) {
            PlaceableCounter counter = placeableTable.get(type);

            if (counter.update()) {
                updatedPlaceables.add(type);
            }
        }

        return updatedPlaceables;
    }

    /**
     * Gets whether this PlaceableType can be placed.
     *
     * @param type The type of placeable.
     * @return True when the PlaceableType can be placed.
     */
    public boolean canPlace(PlaceableType type) {
        PlaceableCounter counter = placeableTable.get(type);
        return counter != null && counter.canPlace();
    }

    /**
     * Increases the count of a given PlaceableType by the given amount.
     * When given a negative amount it will reduce the count of the placeableType.
     *
     * @param type The type of placeable.
     * @param amount The amount to increase the placeable by.
     */
    public void increasePlaceableCount(PlaceableType type, int amount) {
        PlaceableCounter counter = placeableTable.get(type);

        if(counter != null) {
            counter.increaseAmount(amount);
        }
    }
}

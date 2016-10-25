package com.sstengine.player.leader;

import com.sstengine.map.tileobject.PlaceableType;

import java.util.Map;

/**
 * The PlaceableManager class manages all the placeables that a leader could place.
 * The class records a Map of {@link PlaceableType} and {@link PlaceableCounter}.
 * This Map should be populated by extending this class.
 *
 * @author Oscar de Leeuw
 */
public abstract class PlaceableManager {
    private Map<PlaceableType, PlaceableCounter> placeableTable;

    /**
     * Creates a new PlaceableManager.
     *
     * @param placeableTable The map of PlaceableTypes the manager manages.
     */
    protected PlaceableManager(Map<PlaceableType, PlaceableCounter> placeableTable) {
        this.placeableTable = placeableTable;
    }

    /**
     * Updates every counter in the map.
     */
    public final void update() {
        placeableTable.forEach((x,y) -> y.update());
    }

    /**
     * Gets whether this PlaceableType can be placed.
     * @param type The type of placeable.
     * @return True when the PlaceableType can be placed.
     */
    public final boolean canPlace(PlaceableType type) {
        PlaceableCounter counter = placeableTable.get(type);
        return counter != null && counter.canPlace();
    }

    /**
     * Decreases the amount of the given PlaceableType by one.
     * @param type The type of placeable.
     */
    public final void decreasePlaceable(PlaceableType type) {
        PlaceableCounter counter = placeableTable.get(type);

        if(counter != null) {
            counter.decreaseAmount();
        }
    }
}

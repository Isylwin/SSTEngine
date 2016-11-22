package com.sstengine.map.country;

import com.sstengine.GameObject;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.map.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Country class represents a team that exists within the game.<br>
 * Every country has a certain amount of land in tiles.<br>
 * Every country should specify behaviour entering and interacting with a tile that belongs to the country.<br>
 * Every country should specify how it should be drawn graphically.<br>
 *
 * @author Oscar de Leeuw
 */
public class Country extends GameObject {
    private CountryTag tag;
    private List<Tile> land;

    /**
     * Creates a country.
     * Calls the GameObject constructor.
     *
     * @param physical The physical component of this object.
     * @param graphics The graphical component of this object.
     * @param tag      The tag that belongs to this country.
     */
    public Country(PhysicalComponent physical, GraphicsComponent graphics, CountryTag tag) {
        super(physical, graphics);
        this.tag = tag;
        this.land = new ArrayList<>();
    }

    /**
     * Gets the CountryTag of this country.
     * @return The CountryTag of this country.
     */
    public CountryTag getTag() {
        return tag;
    }

    /**
     * Gets the list of tiles that belongs to this country.
     * @return A list of tiles that represents all the land that belongs to this country.
     */
    public List<Tile> getLand() {
        return Collections.unmodifiableList(land);
    }

    /**
     * Adds an tile to this country.
     * @param tile The tile that should be added to the land of this country.
     */
    public void addLand(Tile tile) {
        if (!land.contains(tile)) {
            land.add(tile);
        }
    }
}

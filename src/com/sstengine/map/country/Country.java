package com.sstengine.map.country;

import com.sstengine.map.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Country class represents a team that exists within the game.<br>
 * Every player in the game must belong to a team.<br>
 * Every team has a certain amount of land in tiles.<br>
 * Every team should specify behaviour entering and interacting with a tile that belongs to the team.<br>
 * Every team should specify how it should be drawn graphically.<br>
 *
 * @author Oscar de Leeuw
 */
public class Country {
    private CountryTag tag;
    private List<Tile> land;

    public Country(CountryTag tag) {
        this.tag = tag;
        this.land = new ArrayList<>();
    }

    public CountryTag getTag() {
        return tag;
    }

    public List<Tile> getLand() {
        return Collections.unmodifiableList(land);
    }

    public void addLand(Tile tile) {
        if (!land.contains(tile)) {
            land.add(tile);
        }
    }
}

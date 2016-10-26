package com.sstengine.country;

import com.sstengine.map.tile.Tile;
import com.sstengine.player.leader.Leader;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Country class represents a country that exists within the game.<br>
 * Every player in the game must belong to a country.<br>
 * Every country has a certain amount of land in tiles.<br>
 * Every country should specify behaviour entering and interacting with a tile that belongs to the country.<br>
 * Every country should specify how it should be drawn graphically.<br>
 *
 * @author Oscar de Leeuw
 */
public class Country {
    private CountryTag tag;
    private List<Tile> land;
    private Leader leader;
    private List<PlayerEntity> players;

    public Country(CountryTag tag) {
        this.tag = tag;
        this.land = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public CountryTag getTag() {
        return tag;
    }

    public List<Tile> getLand() {
        return Collections.unmodifiableList(land);
    }

    public void addLand(Tile tile) {
        if(!land.contains(tile)) {
            land.add(tile);
        }
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public List<PlayerEntity> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void addPlayer(PlayerEntity entity) {
        if(!players.contains(entity)) {
            players.add(entity);
        }
    }
}

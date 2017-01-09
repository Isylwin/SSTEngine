package com.sstengine.map;

import com.sstengine.map.tile.Tile;
import com.sstengine.util.enumeration.CardinalDirection;
import com.sstengine.util.enumeration.OrdinalDirection;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 * The Map class represents a collection of tiles that form a map within the CrossTheBorder game.
 *
 * A map is always created from a file with the .ctbmap extension.
 * This file contains the width and the height of the map, the type of tiles that compose the map,
 * the objects that exist on the map and the areas for the Mexican and USA teams.
 *
 * @author Oscar de Leeuw
 */
public class Map implements Serializable {
    private String name;

    private int width;
    private int height;

    private Tile[][] tiles;

    private Map(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.name = builder.name;
        this.tiles = builder.tiles;
    }

    /**
     * Gets the name of the Map.
     *
     * @return A String that represents the name of the map.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the width of the map.
     *
     * @return The width of the map.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Gets the height of the map.
     *
     * @return The height of the map.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets all the tiles on the map.
     * @return All the tiles on the map.
     */
    public Tile[][] getAllTiles() {
        return tiles;
    }

    /**
     * Gets the tile from a given location.
     * Returns null when an {@link ArrayIndexOutOfBoundsException} happens.
     *
     * @param location The location of the requested tile.
     * @return The tile at the given location. Returns null when the given location is out of bounds.
     */
    public Tile getTile(Point location) {
        return getTile(location.x, location.y);
    }

    /**
     * Gets the tile from a given location.
     * Returns null when an {@link ArrayIndexOutOfBoundsException} happens.
     *
     * @param x The x-coordinate of the Tile
     * @param y The y-coordinate of the Tile.
     * @return The tile at the given location. Returns null when the given location is out of bounds.
     */
    public Tile getTile(int x, int y) {
        try {
            return tiles[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            //Intentionally caught and disregarded.
        }
        return null;
    }

    /**
     * Gets the Tile with the given id.
     * Returns null when there is no tile with the given id.
     *
     * @param id The id of the Tile.
     * @return The tile that corresponds with the given id.
     */
    public Tile getTile(int id) {
        return getTiles(x -> x.getId() == id).get(0);
    }

    /**
     * Gets all the tiles that satisfy a given predicate.
     *
     * @param predicate The predicate to test the tile for.
     * @return A list of all the tiles that satisfy the predicate.
     */
    public List<Tile> getTiles(Predicate<? super Tile> predicate) {
        List<Tile> ret = new ArrayList<>();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Tile current = tiles[i][j];
                if (predicate.test(current)) {
                    ret.add(current);
                }
            }
        }

        return ret;
    }

    /**
     * Gets all the direct, non-diagonal, neighbours of a given tile.
     * Uses the {@link CardinalDirection} enum to map every neighbour.
     *
     * @param tile The location of which to get the neighbours.
     * @return A HashMap of all the the neighbouring tiles with the key being the cardinal direction of the neighbour relative to the given tile.
     */
    public java.util.Map<CardinalDirection, Tile> getCardinalNeighbours(Tile tile) {
        java.util.Map<CardinalDirection, Tile> ret = new HashMap<>();

        for (CardinalDirection dir : CardinalDirection.values()) {
            int x = tile.getLocation().x + dir.getCartesianRepresentation().x;
            int y = tile.getLocation().y + dir.getCartesianRepresentation().y;

            Tile neighbour = getTile(x, y);

            ret.put(dir, neighbour);
        }

        return ret;
    }

    /**
     * Gets all the surrounding, including diagonal, neighbours of a given tile.
     * Uses the {@link OrdinalDirection} enum to map every neighbour.
     *
     * @param tile The tile for which to retrieve all the neighbours.
     * @return A HashMap of all the neighbouring tiles with the key being the ordinal direction of the neighbour relative to the given tile.
     */
    public java.util.Map<OrdinalDirection, Tile> getOrdinalNeighbours(Tile tile) {
        java.util.Map<OrdinalDirection, Tile> ret = new HashMap<>();

        for (OrdinalDirection dir : OrdinalDirection.values()) {
            int x = tile.getLocation().x + dir.getCartesianRepresentation().x;
            int y = tile.getLocation().y + dir.getCartesianRepresentation().y;

            Tile neighbour = getTile(x, y);

            ret.put(dir, neighbour);
        }

        return ret;
    }

    /**
     * Builds a map class.
     */
    public static class Builder {
        private String name;
        private int width;
        private int height;
        private Tile[][] tiles;

        /**
         * Makes a map with the given name.
         *
         * @param name The name of the map.
         */
        public Builder(String name) {
            this.name = name;
        }

        /**
         * Sets the width of the map.
         *
         * @param width The width of the map.
         * @return This builder object.
         */
        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        /**
         * Sets the height of the map.
         *
         * @param height The height of the map.
         * @return This builder object.
         */
        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        /**
         * Sets the tiles of the map.
         *
         * @param tiles A two dimensional array of tiles.
         * @return This builder object.
         */
        public Builder setTiles(Tile[][] tiles) {
            this.tiles = tiles;
            return this;
        }

        /**
         * Builds the map.
         *
         * @return A map object.
         */
        public Map build() {
            if (tiles == null || name == null || width == 0 || height == 0) {
                throw new IllegalArgumentException("All properties of the map need to be initialized.");
            }

            return new Map(this);
        }
    }
}
package com.sstengine.map.tile;

import com.sstengine.component.graphics.Graphics;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.graphics.Painter;
import com.sstengine.country.Country;
import com.sstengine.event.framework.Event;
import com.sstengine.obstacle.Obstacle;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.util.Identifiable;

import java.awt.*;
import java.util.List;

/**
 *  Represents a single tile that composes the map.
 *  The tile has a certain location.
 *
 *  @author Oscar de Leeuw
 */
public final class Tile implements Graphics, Identifiable {
    private int id;
    private TileType type;
    private Point location;
    private GraphicsComponent graphics;

    private Obstacle obstacle;
    private PlayerEntity playerEntity;
    private Country country;


    /**
     * Creates a new tile object with the given location, team and type.
     *
     * @param id The id of this tile.
     * @param graphics The graphical component for this tile.
     * @param type The type of the tile.
     * @param location The location of the tile.
     */
    public Tile(int id, GraphicsComponent graphics, TileType type, Point location) {
        this.id = id;
        this.graphics = graphics;
        this.type = type;
        this.location = location;
    }

    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Gets the location of this tile.
     *
     * @return A point that represents the location of this tile.
     */
    public Point getLocation() {
        return this.location;
    }

    /**
     * Gets the type of the Tile.
     *
     * @return A TileType that represents the type of the tile.
     */
    public TileType getType() {
        return type;
    }

    /**
     * Gets the team that this tile belongs to.
     *
     * @return The team that belongs to this tile.
     */
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Gets the PlayerEntity that lives on this tile.
     *
     * @return The PlayerEntity object.
     */
    public PlayerEntity getPlayerEntity() {
        return this.playerEntity;
    }

    /**
     * Sets the PlayerEntity of this tile.
     *
     * @param playerEntity The PlayerEntity that should occupy this tile.
     */
    public void setPlayerEntity(PlayerEntity playerEntity) {
        if (playerEntity != null) {
            playerEntity.setTile(this);
        }
        this.playerEntity = playerEntity;
    }

    /**
     * Returns the {@link Obstacle} this tile has. Returns null if it does not have a {@link Obstacle}.
     *
     * @return The {@link Obstacle} object. Can be null.
     */
    public Obstacle getObstacle() {
        return this.obstacle;
    }

    /**
     * Sets the {@link Obstacle} for this tile.
     *
     * @param tileObject The object that fills the tile.
     */
    public void setObstacle(Obstacle tileObject) {
        if (tileObject != null) {
            tileObject.setTile(this);
        }
        this.obstacle = tileObject;
    }

    /**
     * Returns whether the tile has a {@link Obstacle} or not.
     *
     * @return True if the tile has a {@link Obstacle}. False if it doesn't have a {@link Obstacle}.
     */
    public boolean hasObstacle() {
        return this.obstacle != null;
    }

    /**
     * Returns whether this tile has a PlayerEntity.
     *
     * @return A boolean that indicates whether this tile has a PlayerEntity.
     */
    public boolean hasPlayerEntity() {
        return this.playerEntity != null;
    }

    /**
     * Returns whether this tile has a Country associated with it.
     *
     * @return True when this tile has a Country associated with it.
     */
    public boolean hasCountry() {
        return this.country != null;
    }

    /**
     * Calls all the interactWith methods on all GameObjects that exist on this tile.
     *
     * @param entity     The entity that is interacting with the GameObject.
     * @param eventQueue The queue of events to which the interaction can add events.
     */
    public void interactWithGameObjects(PlayerEntity entity, List<Event> eventQueue) {
        if (playerEntity != null) {
            playerEntity.interactWith(entity, eventQueue);
        }
        if (obstacle != null) {
            obstacle.interactWith(entity, eventQueue);
        }
        if (country != null) {
            country.interactWith(entity, eventQueue);
        }
    }

    /**
     * Gets whether the given entity can access this tile.
     *
     * @param entity The entity for which to check the accessibility.
     * @return True when the entity can enter the tile.
     */
    public boolean isAccessible(PlayerEntity entity) {
        boolean tileObjectAccess = obstacle == null || obstacle.isAccessible(entity);
        boolean playerEntityAccess = playerEntity == null || playerEntity.isAccessible(entity);
        boolean countryAccess = country == null || country.isAccessible(entity);

        return countryAccess && tileObjectAccess && playerEntityAccess;
    }

    @Override
    public void render(Painter painter, Point location, int width, int height) {
        graphics.render(this, painter, location, width, height);

        if (country != null) {
            country.render(painter, location, width, height);
        }
        if (obstacle != null) {
            obstacle.render(painter, location, width, height);
        }
        if (playerEntity != null) {
            playerEntity.render(painter, location, width, height);
        }
    }
}

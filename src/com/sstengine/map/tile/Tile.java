package com.sstengine.map.tile;

import com.sstengine.GameObject;
import com.sstengine.map.country.Country;
import com.sstengine.map.obstacle.Obstacle;
import com.sstengine.player.playerentity.PlayerEntity;

import java.awt.*;

/**
 *  Represents a single tile that composes the map.
 *  The tile has a certain location.
 *
 *  @author Oscar de Leeuw
 */
public class Tile extends GameObject {
    private Obstacle obstacle;
    private PlayerEntity playerEntity;
    private TileType type;
    private Country country;
    private Point location;

    /**
     * Creates a new tile object with the given location, team and type.
     *
     * @param type The type of the tile.
     * @param location The location of the tile.
     */
    public Tile(TileType type, Point location) {
        super(null, null); //TODO create special Tile Components.
        this.type = type;
        this.location = location;
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

    public boolean hasCountry() {
        return this.country != null;
    }

    /**
     * Gets the cost for moving into this tile.
     *
     * @param entity The entity that will be moving into this tile.
     * @return The cost for moving into this tile in server ticks.
     */
    /*public int getCost(PlayerEntity entity) throws Exception {
        int countryCost = team.getCost(entity);
        int playerEntityCost = playerEntity != null ? playerEntity.getCost(entity) : 0;
        int tileObjectCost = obstacle != null ? obstacle.getCost(entity) : 0;

        if (countryCost == -1 || playerEntityCost == -1 || tileObjectCost == -1) {
            throw new Exception("Undefined cost, possibly cost request to an tile that is inaccessible"); //TODO make a custom exception.
        }

        return 1 + countryCost + playerEntityCost + tileObjectCost;
        return 1;
    }*/

    /**
     * Gets whether the given entity can access this tile.
     *
     * @param entity The entity for which to check the accessibility.
     * @return True when the entity can enter the tile.
     */
    /*public boolean isAccessible(PlayerEntity entity) {
        boolean tileObjectAccess = obstacle == null || obstacle.isAccessible(entity);
        boolean playerEntityAccess = playerEntity == null || playerEntity.isAccessible(entity);
        boolean countryAccess = team.isAccessible(entity);

        return countryAccess && tileObjectAccess && playerEntityAccess;
        return false;
    }*/


    /*public void draw(Painter painter, Point location, int tileWidth) {
        File file = ImageFinder.getInstance().getImage(type);
        painter.drawImage(file, location, tileWidth, tileWidth);

        if (hasObstacle()) {
            obstacle.draw(painter, location, tileWidth);
        }
        if (hasPlayerEntity()) {
            playerEntity.draw(painter, location, tileWidth);
        }

        team.draw(painter, location, tileWidth);
    }*/
}

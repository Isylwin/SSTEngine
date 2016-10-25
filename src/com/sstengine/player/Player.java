package com.sstengine.player;

import com.sstengine.Game;
import com.sstengine.GameSettings;
import com.sstengine.Team;
import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.MoveDirection;

import java.util.List;

import java.awt.*;

/**
 * Player is the super class for Leader and PlayerEntity.
 *
 * @author Oscar de Leeuw
 */
public abstract class Player {
    protected Point cameraLocation;
    private String name;
    private Team team;

    /**
     * Abstract constructor that sets the name of the player.
     *
     * @param name The name of the player.
     * @param team The team the player is part of.
     */
    public Player(String name, Team team) {
        this.name = name;
        this.team = team;
        team.addTeamMember(this);
        cameraLocation = new Point(0, 0);
    }

    /**
     * Gets the team this player is apart of.
     *
     * @return A team object.
     */
    public Team getTeam() {
        return this.team;
    }

    /**
     * Gets the location of a camera of a player.
     *
     * @return The location of the camera.
     */
    public Point getCameraLocation() {
        return this.cameraLocation;
    }

    /**
     * Moves the location of a camera.
     * Does not work for PlayerEntities.
     *
     * @param md The direction the camera should move.
     */
    public void moveCameraLocation(MoveDirection md) {
        this.cameraLocation = md.getLocationWithMove(cameraLocation);
    }

    /**
     * Updates the player and generates all the events that should happen during this update.
     *
     * @param game The game in which the player lives.
     * @param eventQueue The queue of events that will be executed by the game.
     */
    public abstract void update(Game game, List<Event> eventQueue);

    @Override
    public String toString(){
        return name;
    }
}

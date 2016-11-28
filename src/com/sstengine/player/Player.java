package com.sstengine.player;

import com.sstengine.Game;
import com.sstengine.event.framework.Event;
import com.sstengine.player.leader.Leader;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.team.Team;
import com.sstengine.util.Identifiable;

import java.util.List;

/**
 * The Player class represents a player within the game.
 * The Player holds either a {@link Leader} or a {@link PlayerEntity}.
 * Player should be updated at every tick and relegates the update request to the underlying entity.
 * Player serves as the interface to push input to the underlying entity.
 *
 * @author Oscar de Leeuw
 */
public class Player implements Identifiable {
    private int id;
    private String name;
    private Team team;

    private Playable playable;

    /**
     * Private constructor that sets the name and team of the player.
     *
     * @param id The id of the player.
     * @param name The name of the player.
     * @param team The team the player is part of.
     */
    private Player(int id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    /**
     * Creates a new Player that wraps a Leader.
     *
     * @param id     The id of the player.
     * @param name   The name of the player.
     * @param team   The team the player is part of.
     * @param leader The Leader that this player wraps.
     */
    public Player(int id, String name, Team team, Leader leader) {
        this(id, name, team);
        this.playable = leader;
        team.setLeader(leader);
    }

    /**
     * Creates a new Player that wraps a PlayerEntity.
     *
     * @param id     The id of the player.
     * @param name   The name of the player.
     * @param team   The team the player is part of.
     * @param entity The PlayerEntity that this Player wraps.
     */
    public Player(int id, String name, Team team, PlayerEntity entity) {
        this(id, name, team);
        this.playable = entity;
        team.addPlayerEntity(entity);
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the Player.
     *
     * @return A String that represents the name of the Player.
     */
    public String getName() {
        return this.name;
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
     * Updates the Playable that is controlled by this Player.
     *
     * @param game The game in which the player lives.
     * @param eventQueue The queue of events that will be executed by the game.
     */
    public void update(Game game, List<Event> eventQueue) {
        playable.update(game, eventQueue);
    }

    /**
     * Pushes input to the Playable that is controlled by this Player.
     *
     * @param input The input that should be pushed to the underlying Playable.
     */
    public void pushInput(PlayerInput input) {
        playable.pushInput(input);
    }

    @Override
    public String toString(){
        return name;
    }
}

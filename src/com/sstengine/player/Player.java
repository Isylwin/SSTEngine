package com.sstengine.player;

import com.sstengine.Game;
import com.sstengine.event.framework.Event;
import com.sstengine.player.leader.Leader;
import com.sstengine.player.leader.LeaderInput;
import com.sstengine.player.playerentity.MoveDirection;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.team.Team;

import java.util.List;

/**
 * The Player class represents a player within the game.
 * The Player holds either a {@link Leader} or a {@link PlayerEntity}.
 * Player should be updated at every tick and relegates the update request to the underlying entity.
 * Player serves as the interface to push input to the underlying entity.
 *
 * @author Oscar de Leeuw
 */
public class Player {
    private String name;
    private Team team;

    private Leader leader;
    private PlayerEntity entity;

    /**
     * Private constructor that sets the name and team of the player.
     *
     * @param name The name of the player.
     * @param team The team the player is part of.
     */
    private Player(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public Player(String name, Team team, Leader leader) {
        this(name, team);
        this.leader = leader;
        team.setLeader(leader);
    }

    public Player(String name, Team team, PlayerEntity entity) {
        this(name, team);
        this.entity = entity;
        team.addPlayerEntity(entity);
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
     * Updates the player. Calls either the update on the leader or entity
     *
     * @param game The game in which the player lives.
     * @param eventQueue The queue of events that will be executed by the game.
     */
    public void update(Game game, List<Event> eventQueue) {
        if (leader != null) {
            leader.update(game, eventQueue);
        } else if (entity != null) {
            entity.update(game, eventQueue);
        } else {
            //TODO exception.
        }
    }

    /**
     * Pushes input to the underlying Leader or PlayerEntity that is controlled by this Player.
     *
     * @param input The input that should be pushed to the underlying entity.
     */
    public void pushInput(Object input) {
        if (leader != null) {
            LeaderInput li = (LeaderInput) input;
            leader.pushInput(li);
        } else if (entity != null) {
            MoveDirection md = (MoveDirection) input;
            entity.pushInput(md);
        } else {
            //TODO exception.
        }
    }

    @Override
    public String toString(){
        return name;
    }
}

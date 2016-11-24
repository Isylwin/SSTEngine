package com.sstengine.team;

import com.sstengine.map.country.Country;
import com.sstengine.player.leader.Leader;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Team class represents a team within the {@link com.sstengine.Game}.
 * Every {@link com.sstengine.player.Player} in the Game must belong to a team.
 *
 * A Team consists of a {@link Country} and a score.
 * A Team can only have one {@link Leader} but it can have multiple {@link PlayerEntity}.
 *
 * @author Oscar de Leeuw
 */
public class Team {
    private Country country;
    private int score;

    private Leader leader;
    private List<PlayerEntity> playerEntities;

    /**
     * Constructor of Team class.
     *
     * @param country The team of the team.
     */
    public Team(Country country) {
        this.country = country;
        this.score = 0;
        this.playerEntities = new ArrayList<>();
    }

    /**
     * Gets score of team.
     *
     * @return score of team
     */
    public int getScore() {
        return score;
    }

    /**
     * Increases the score by the given amount.
     *
     * @param change The amount of change.
     */
    public void changeScore(int change) {
        this.score += change;
    }

    /**
     * Gets team of the team.
     *
     * @return The team of the team.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Gets the leader of this Team.
     * A team can only have one leader.
     *
     * @return The leader of the Team.
     */
    public Leader getLeader() {
        return leader;
    }

    /**
     * Sets the leader of this Team.
     *
     * @param leader The leader that should be the leader of this Team.
     */
    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    /**
     * Gets all the PlayerEntities that are associated with this team.
     * @return A List of all the PlayerEntities that belong to this team.
     */
    public List<PlayerEntity> getPlayerEntities() {
        return Collections.unmodifiableList(playerEntities);
    }

    /**
     * Adds a given PlayerEntity to the Team if the Team doesn't already contain a PlayerEntity.
     * @param entity The PlayerEntity that should be added to the Team.
     */
    public void addPlayerEntity(PlayerEntity entity) {
        if (!playerEntities.contains(entity)) {
            playerEntities.add(entity);
        }
    }
}

package com.sstengine.team;

import com.sstengine.map.country.Country;
import com.sstengine.player.leader.Leader;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A team consists of a team name, a score and a list of teamMembers.
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

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public List<PlayerEntity> getPlayerEntities() {
        return Collections.unmodifiableList(playerEntities);
    }

    public void addPlayerEntity(PlayerEntity entity) {
        if (!playerEntities.contains(entity)) {
            playerEntities.add(entity);
        }
    }
}

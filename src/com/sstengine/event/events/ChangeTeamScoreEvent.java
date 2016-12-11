package com.sstengine.event.events;

import com.sstengine.team.Team;

import java.util.Objects;

/**
 * The ChangeTeamScoreEvent is an event that changes the score of a given team by a given amount.
 *
 * @author Oscar de Leeuw
 */
public class ChangeTeamScoreEvent extends AbstractEvent {
    private Team team;
    private int scoreChange;

    /**
     * Creates a new ChangeTeamScoreEvent.
     *
     * @param team        The team that is involved in the event.
     * @param scoreChange The amount the score should be changed by.
     */
    public ChangeTeamScoreEvent(Team team, int scoreChange) {
        Objects.requireNonNull(team, "Team cannot be null.");

        this.team = team;
        this.scoreChange = scoreChange;
    }

    /**
     * Gets the team that is associated with this event.
     *
     * @return The team that is associated with this event.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Gets the change in score.
     *
     * @return The amount the score should be changed by.
     */
    public int getScoreChange() {
        return scoreChange;
    }
}

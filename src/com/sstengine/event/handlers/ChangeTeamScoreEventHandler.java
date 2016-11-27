package com.sstengine.event.handlers;

import com.sstengine.Game;
import com.sstengine.event.events.ChangeTeamScoreEvent;
import com.sstengine.event.framework.Handler;
import com.sstengine.team.Team;

/**
 * The ChangeTeamScoreEventHandler handles a ChangeTeamScoreEvent.
 * It increases the score of the given team by the change in the event.
 *
 * @author Oscar de Leeuw
 */
public class ChangeTeamScoreEventHandler implements Handler<ChangeTeamScoreEvent> {
    @Override
    public void onEvent(ChangeTeamScoreEvent event, Game game) {
        Team team = event.getTeam();
        int change = event.getScoreChange();

        team.changeScore(change);
    }
}

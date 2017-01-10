package com.sstengine.event.handlers;

import com.sstengine.event.events.ChangeTeamScoreEvent;
import com.sstengine.team.Team;
import com.sstengine.testutil.TestUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Oscar de Leeuw
 */
public class ChangeTeamScoreEventHandlerTest {
    Team team;
    int change;
    ChangeTeamScoreEvent event;
    ChangeTeamScoreEventHandler handler;

    @Before
    public void setUp() throws Exception {
        team = TestUtil.makeTeam(0, null);
        handler = new ChangeTeamScoreEventHandler();
    }

    private void testEvent(int change) {
        event = new ChangeTeamScoreEvent(team, change);
        int currScore = team.getScore();

        handler.onEvent(event, null);

        assertEquals(currScore + change, team.getScore());
    }

    @Test
    public void onEvent_ChangeOne_ShouldRaiseScoreByOne() throws Exception {
        testEvent(1);
    }

    @Test
    public void onEvent_ChangeSix_ShouldRaiseScoreBySix() throws Exception {
        testEvent(6);
    }
}
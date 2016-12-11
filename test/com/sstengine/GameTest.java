package com.sstengine;

import com.sstengine.game.GameSettings;
import com.sstengine.map.Map;
import com.sstengine.mocks.MockGameSettings;
import com.sstengine.player.Player;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.team.Team;
import com.sstengine.testutil.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author Oscar de Leeuw
 */
public class GameTest {
    Game game;

    @Before
    public void setUp() throws Exception {
        Map map = TestUtil.makeMap(60, 60);
        GameSettings settings = new MockGameSettings();
        List<Team> teams = TestUtil.makeTeams(map);

        game = new Game(settings, map, teams);
        game.addPlayer(TestUtil.makePlayer(1, "Henk", teams.get(0)));
        game.addPlayer(TestUtil.makePlayer(2, "Gert", teams.get(1)));
        game.addPlayer(TestUtil.makePlayer(3, "Piet", teams.get(0)));
        game.addPlayer(TestUtil.makePlayer(4, "Jan", teams.get(1)));
        game.addPlayer(TestUtil.makePlayer(5, "Kek", teams.get(1)));
    }

    @Test
    public void respawnAllPlayers_WithMultiplePlayer_ReturnsNotNull() {
        game.respawnAllPlayers();

        for (Player player : game.getPlayers()) {
            PlayerEntity entity = (PlayerEntity) player.getPlayable();

            Assert.assertNotNull(entity.getTile());
        }
    }

    @Test
    public void update_WithMultiplePlayers_ReturnsNotNull() {
        game.respawnAllPlayers();

        for (int i = 0; i < 50; i++) {
            game.update();
        }
    }

    @Test
    public void update_WithAlotOfTime_ShouldStop() {
        game.respawnAllPlayers();

        for (int i = 0; i < 600; i++) {
            game.update();
        }

        Assert.assertTrue(game.isDone());
    }

    @Test
    public void serialize_WithNothing_ShouldSerialize() throws IOException {
        File temp = new File("temp.dat");
        temp.deleteOnExit();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp));
        oos.writeObject(game);
        oos.close();

        System.out.println("Space used: " + temp.length());
    }

}
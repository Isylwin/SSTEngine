package com.sstengine.game;

import com.sstengine.Game;
import com.sstengine.map.Map;
import com.sstengine.team.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * The GameStepBuilder builds a game with steps, as the Game object has to be build in a certain order of steps.
 * Builds a game in the following order: Settings, Map, Teams.
 *
 * @author Oscar de Leeuw
 */
public class GameStepBuilder {
    private GameStepBuilder() {
    }

    public static SettingsStep newBuilder() {
        return new GameSteps();
    }

    interface SettingsStep {
        MapStep withSettings(GameSettings settings);
    }

    interface MapStep {
        TeamStep withMap(Map map);
    }

    interface TeamStep {
        TeamStep withTeam(Team team);

        BuildStep noMoreTeam();
    }

    interface BuildStep {
        Game build();
    }

    private static class GameSteps implements SettingsStep, MapStep, TeamStep, BuildStep {
        private GameSettings settings;
        private Map map;
        private List<Team> teams = new ArrayList<>();

        @Override
        public TeamStep withMap(Map map) {
            this.map = map;
            return this;
        }

        @Override
        public TeamStep withTeam(Team team) {
            this.teams.add(team);
            return this;
        }

        @Override
        public BuildStep noMoreTeam() {
            return this;
        }

        @Override
        public Game build() {
            return new Game(settings, map, teams);
        }

        @Override
        public MapStep withSettings(GameSettings settings) {
            this.settings = settings;
            return this;
        }
    }
}

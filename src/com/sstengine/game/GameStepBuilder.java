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

    /**
     * Starts a new GameStepBuilder.
     * Will start of with a GameSettings.
     *
     * @return A SettingStep, which is the next step.
     */
    public static SettingsStep newBuilder() {
        return new GameSteps();
    }

    /**
     * Represents the step in which a GameSetting is added to the Game.
     */
    @FunctionalInterface
    public interface SettingsStep {
        /**
         * Adds a GameSetting to the building process.
         *
         * @param settings The settings that are added to the building process.
         * @return A MapStep, which is the next step in the process.
         */
        MapStep withSettings(GameSettings settings);
    }

    /**
     * Represents the step in which a Map is added to the Game.
     */
    @FunctionalInterface
    public interface MapStep {
        /**
         * Adds a Map to the building process.
         *
         * @param map The Map that is added to the building process.
         * @return A TeamStep, which is the next step in the process.
         */
        TeamStep withMap(Map map);
    }

    /**
     * Represents the step in which a Team is added to the Game.
     */
    public interface TeamStep {
        /**
         * Adds a team to the building team.
         *
         * @param team The team that should be added to the building process.
         * @return A TeamStep, which will allow another team to be added to the Game.
         */
        TeamStep withTeam(Team team);

        /**
         * Stops adding teams to the Game and is the end of the StepBuilder.
         * @return A BuildStep, which will allow the Game to be build.
         */
        BuildStep noMoreTeam();
    }

    /**
     * Represents the final step in the process from which the Game can be build.
     */
    @FunctionalInterface
    public interface BuildStep {
        /**
         * Builds the game.
         * @return The game that has formed by the StepBuilder.
         */
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

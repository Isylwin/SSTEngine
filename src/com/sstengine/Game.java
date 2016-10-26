package com.sstengine;

import com.sstengine.map.Map;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.team.Team;
import com.sstengine.util.GameSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * This class makes an instance of Game.
 *
 * @author Oscar de Leeuw
 */
public class Game {
    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());
    private static final int ENGINE_TICK_RATE = 5; //TODO Change this too a constant class.
    private GameSettings settings;
    private Timer timer = new Timer();
    private boolean inProgress;

    private int scoreLimit;
    private int timeLimit;

    //private Leader trump; //TODO make this am instance of superplayer/authorityfigure/idk.
    private List<PlayerEntity> players = new ArrayList<>();
    //private List<Computer> computers = new ArrayList<>();

    private Map map;
    private Team usa;
    private Team mex;

    /**
     * Constructor of Game class.
     *
     * @param mapName The name of the map.
     */
    public Game(String mapName) {
        //this.settings = new GameSettingsImpl(ENGINE_TICK_RATE); //TODO must become a constructor parameter.
        this.scoreLimit = settings.getScoreLimit();
        this.timeLimit = settings.getTimeLimit() * ENGINE_TICK_RATE;
        //this.map = MapLoader.getInstance().buildMap(mapName); //TODO Look into making maploader part of the engine. Maybe with the help of maploader settings.
        //usa = new Team(CountryTemp.USA, map.getUsaArea(), settings.getUsaScoringModifier()); //TODO should not be two set teams.
        //mex = new Team(CountryTemp.MEX, map.getMexicoArea(), settings.getMexicanScoringModifier());
    }

    /**
     * Gets the map of the game.
     *
     * @return The map that is used by the game.
     */
    public Map getMap() {
        return this.map;
    }

    /**
     * Gets the game settings for this game.
     *
     * @return The settings of this game.
     */
    public GameSettings getSettings() {
        return this.settings;
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        this.inProgress = true;
        //this.computers.forEach(computer -> computer.resetComputer(map));

        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 1000 / ENGINE_TICK_RATE);
    }

    /**
     * Turns a user into a player and adds the player to the game.
     * Will try to create a Leader if there is none.
     * Will try to create a Mexican if there are more Americans than Mexicans.
     * Will otherwise try to create a BorderPatrol.
     *
     */
    public void addPlayer() {
        /*Player player;

        //If trump does not exist make the user a trump.
        if (trump == null && !user.isComputer()) {
            trump = new Trump(user.getName(), usa, settings);
            //Little hackish to set the camera location somewhere in the USA area.
            Point initCameraLoc = (Point) map.getTileInArea(usa.getTeamArea()).getLocation().clone();
            trump.getCameraLocation().setLocation(initCameraLoc);
            player = trump;
        } else {
            Team team;
            PlayerEntity playerEntity;
            //TODO: Make a player factory.

            //Else make a new american.
            if (usa.getTeamMembers().size() > mex.getTeamMembers().size()) {
                team = mex;
                playerEntity = new Mexican(user.getName(), team, settings);
            }

            //If there are more USA members than mexicans, make a new mexican.
            else {
                team = usa;
                playerEntity = new BorderPatrol(user.getName(), team, settings);
            }

            player = playerEntity;
            players.add(playerEntity);
            respawnPlayer(playerEntity);

            //If the user has the computer flag, add it to the computers.
            if (user.isComputer()) {
                Computer computer = new Computer(playerEntity);
                computers.add(computer);
            }
        }

        user.setPlayer(player);*/
    }

    /**
     * Update is called at every tick of the game timer.
     */
    public void update(){
        /*//Update all the player entities.
        for (PlayerEntity player : players) {
            //Move the player if there is input.
            Point nextLocation = player.getNextMove();
            if (nextLocation != null) {
                movePlayerEntity(player, nextLocation);
            }
            //Decrease the immobilization timer.
            player.decreaseMoveTimer();
        }

        //Tick the placeables for Leader.
        trump.tickPlaceableAmount();

        //Let all the computers compute
        computers.forEach(computer -> computer.computeMove(map));

        //Check whether time has expired.
        timeLimit--;
        checkTime();*/
    }

    /**
     * Checks whether the score limit has been reached.
     */
    private void checkScore() {
        if (mex.getScore() >= scoreLimit || usa.getScore() >= scoreLimit) {
            stop();
        }
    }

    /**
     * Checks whether the time limit has been reached.
     */
    private void checkTime() {
        if (timeLimit <= 0) {
            stop();
        }
    }

    /**
     * Stops the game.
     */
    public void stop() {
        timer.cancel();
        this.inProgress = false;
    }

    /*public void movePlayerEntity(PlayerEntity player, Point nextLocation) {
        Tile nextTile = map.getTile(nextLocation);

        //If the tile is accessible try to move to it.
        if (nextTile.isAccessible(player)) {

            //Boolean to store whether further evaluation of interaction/movement is needed.
            boolean shouldMove = true;

            //Check whether there's a PlayerEntity at the next location.
            if (nextTile.hasPlayerEntity()) {
                shouldMove = nextTile.getPlayerEntity().interactWith(player, this);
            }

            //Check whether there's a TileObject at the next location.
            if (shouldMove && nextTile.hasObstacle()) {
                shouldMove = nextTile.getObstacle().interactWith(player, this);
            }

            //Interact with the team of the next location.
            if (shouldMove) {
                shouldMove = nextTile.getCountry().interactWith(player, this);
            }

            //If the movement should be executed, move the player.
            if (shouldMove) {
                changePlayerEntityLocation(player, nextTile);
            }
        }
    }

    @Override
    public void respawnPlayer(PlayerEntity player) {
        //Get a free point in the team area of the player.
        Tile nextLocation = map.getFreeTileInArea(player.getTeam().getTeamArea(), player);

        //player.immobilize(settings.getRespawnTime());
        changePlayerEntityLocation(player, nextLocation);
    }

    @Override
    public void increaseScore(Team team) {
        team.increaseScore();

        System.out.printf("Mexican score = %1$d | Usa score = %2$d\n", mex.getScore(), usa.getScore()); //TODO REMOVE THIS.

        //Check whether the score limit has been reached.
        checkScore();
    }

    @Override
    public void changePlayerEntityLocation(PlayerEntity entity, Tile nextLocation) {
        Tile currentLocation = entity.getTile();

        if (currentLocation != null) {
            currentLocation.setPlayerEntity(null);
        }
        nextLocation.setPlayerEntity(entity);
    }

    @Override
    public void changeTileObjectLocation(TileObject object, Tile nextLocation) {
        Tile currentLocation = object.getTile();

        if (currentLocation != null) {
            currentLocation.setObstacle(null);
        }
        nextLocation.setObstacle(object);
    }

    @Override
    public void removeTileObject(TileObject tileObject) {
        tileObject.getTile().setObstacle(null);
    }

    @Override
    public Camera getCamera(Point center, int tileWidth, int cameraWidth, int cameraHeight) {
        return map.getCamera(center, tileWidth, cameraWidth, cameraHeight);
    }

    @Override
    public Team getUsa() {
        return this.usa;
    }

    @Override
    public Team getMexico() {
        return this.mex;
    }

    @Override
    public int getRemainingTime() {
        throw new UnsupportedOperationException(); //TODO add time limit to the game.
    }

    @Override
    public void sendMoveInput(MoveDirection md, PlayerEntity player) {
        if (players.contains(player)) {
            player.pushInput(md);
        }
    }

    @Override
    public void addPlaceable(Point location, PlaceableType placeableType) {
        try {
            Tile tile = map.getTile(location);
            Placeable placeable = placeableType.getPlaceable(settings);

            if (trump.canPlace(placeable) && map.canPlacePlaceable(tile, placeable)) {
                changeTileObjectLocation(placeable, tile);
                trump.decreasePlaceableAmount(placeable);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
    }*/
}
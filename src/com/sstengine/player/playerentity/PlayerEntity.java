package com.sstengine.player.playerentity;

import com.sstengine.Game;
import com.sstengine.GameSettings;
import com.sstengine.Interactable;
import com.sstengine.drawing.Drawable;
import com.sstengine.drawing.Painter;
import com.sstengine.event.framework.Event;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.Player;
import com.sstengine.Team;
import com.sstengine.state.State;
import com.sstengine.state.states.NormalState;

import java.awt.*;
import java.util.List;


/**
 * The PlayerEntity class defines what constitutes as a PlayerEntity within the SSTEngine.
 *
 * @author Oscar de Leeuw
 */
public abstract class PlayerEntity extends Player implements Drawable, Interactable {
    private Tile tile;
    private InputBuffer inputBuffer;
    private MoveDirection currentMove;
    private State state;

    /**
     * Abstract constructor that passes the name to the Player class.
     * Calls the {@link Player#Player(String, Team, GameSettings)} constructor.
     * @param name The name of the player.
     * @param team The team this player is part of.
     * @param settings The settings of the game.
     */
    public PlayerEntity(String name, Team team, GameSettings settings) {
        super(name, team, settings);
        this.state = new NormalState();
        this.inputBuffer = new InputBuffer();
    }

    /**
     * Gets the location of the PlayerEntity.
     * Will return the location of the tile this PlayerEntity belongs to.
     *
     * @return A point that represents the location of the PlayerEntity.
     */
    public Point getLocation() {
        return this.tile.getLocation();
    }

    /**
     * Gets the current move of this PlayerEntity.
     * @return The current move of this PlayerEntity.
     */
    public MoveDirection getCurrentMove() {
        return this.currentMove;
    }

    /**
     * Gets the current State of the PlayerEntity.
     * @return The current State of the PlayerEntity.
     */
    public State getState() {
        return state;
    }

    @Override
    public Tile getTile() {
        return this.tile;
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void update(Game game, List<Event> eventQueue) {
        currentMove = inputBuffer.getNextInputMove();

        state.handleInput(this, game.getMap(), eventQueue);
    }

    /**
     * Pushes a MoveDirection to the {@link InputBuffer}.
     *
     * @param move The MoveDirection that should be pushed to the InputBuffer.
     */
    public void pushInput(MoveDirection move) {
        inputBuffer.addToInputMoves(move);
    }

    /**
     * {@inheritDoc}
     * Returns a clone of the location of the object.
     */
    @Override
    public Point getCameraLocation() {
        return (Point) this.tile.getLocation().clone();
    }

    /**
     * {@inheritDoc}
     * Is intentionally left blank. Camera movement for player entities is not supported.
     */
    @Override
    public void moveCameraLocation(MoveDirection md) {
        //Intentionally left blank. Cannot support moving the camera due to the way player location is updated.
    }

    @Override
    public void draw(Painter painter, Point location, int tileWidth) {

    }
}

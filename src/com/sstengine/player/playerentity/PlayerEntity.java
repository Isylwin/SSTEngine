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
public class PlayerEntity extends Player {
    private Tile tile;
    private InputBuffer inputBuffer;
    private MoveDirection currentMove;
    private State state;

    /**
     * Abstract constructor that passes the name to the Player class.
     * Calls the {@link Player#Player(String, Team)} constructor.
     * @param name The name of the player.
     * @param team The team this player is part of.
     */
    public PlayerEntity(String name, Team team) {
        super(name, team);
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
     * Pushes a MoveDirection to the {@link InputBuffer}.
     *
     * @param move The MoveDirection that should be pushed to the InputBuffer.
     */
    public void pushInput(MoveDirection move) {
        inputBuffer.addToInputMoves(move);
    }

    /**
     * Gets the current State of the PlayerEntity.
     * @return The current State of the PlayerEntity.
     */
    public State getState() {
        return state;
    }


    public Tile getTile() {
        return this.tile;
    }


    public void setTile(Tile tile) {
        this.tile = tile;
        this.cameraLocation = tile.getLocation();
    }

    @Override
    public void update(Game game, List<Event> eventQueue) {
        currentMove = inputBuffer.getNextInputMove();

        state.handleInput(this, game.getMap(), eventQueue);
    }
}

package com.sstengine.player.playerentity;

import com.sstengine.Game;
import com.sstengine.GameObject;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.event.framework.Event;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.playerentity.states.NormalState;

import java.awt.*;
import java.util.List;

/**
 * The PlayerEntity class defines what constitutes as a PlayerEntity within the SSTEngine.
 * PlayerEntity extends the GameObject class.
 *
 * A PlayerEntity exists on a tile.
 * A PlayerEntity has a certain state which defines how it reacts to input.
 *
 * @author Oscar de Leeuw
 */
public class PlayerEntity extends GameObject {
    private Tile tile;
    private InputBuffer inputBuffer;
    private MoveDirection currentMove;
    private State state;

    /**
     * Creates a new PlayerEntity.
     * Calls the constructor of {@link GameObject}.
     *
     * @param physical The physical component of the PlayerEntity.
     * @param graphics The graphical component of the PlayerEntity.
     */
    public PlayerEntity(PhysicalComponent physical, GraphicsComponent graphics) {
        super(physical, graphics);
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
     * Gets the current State of the PlayerEntity.
     * @return The current State of the PlayerEntity.
     */
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Tile getTile() {
        return this.tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        //this.cameraLocation = tile.getLocation();
    }

    /**
     * Gets the current move of this PlayerEntity.
     *
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

    public void update(Game game, List<Event> eventQueue) {
        currentMove = inputBuffer.getNextInputMove();

        state.handleInput(this, game.getMap(), eventQueue);
    }
}
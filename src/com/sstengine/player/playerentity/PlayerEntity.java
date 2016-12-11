package com.sstengine.player.playerentity;

import com.sstengine.Game;
import com.sstengine.GameObject;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.event.framework.Event;
import com.sstengine.map.tile.Tile;
import com.sstengine.player.Playable;
import com.sstengine.player.Player;
import com.sstengine.player.PlayerInput;
import com.sstengine.player.playerentity.states.NormalState;
import com.sstengine.team.Team;

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
public class PlayerEntity extends GameObject implements Playable {
    private Player player;

    private Tile tile;

    private transient InputBuffer inputBuffer;
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

    @Override
    public int getId() {
        return player.getId();
    }

    /**
     * Gets the Team that this PlayerEntity belongs to.
     *
     * @return The Team that the PlayerEntity belongs to.
     */
    public Team getTeam() {
        return player.getTeam();
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

    /**
     * Sets the current State of the PlayerEntity.
     *
     * @param state The new State of the PlayerEntity.
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets the Tile that this PlayerEntity lives on.
     * @return The Tile that this PlayerEntity lives on.
     */
    public Tile getTile() {
        return this.tile;
    }

    /**
     * Sets the Tile that this PlayerEntity lives on.
     * @param tile The new Tile that this PlayerEntity lives on.
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    /**
     * Gets the current move of this PlayerEntity.
     *
     * @return The current move of this PlayerEntity.
     */
    public MoveDirection getCurrentMove() {
        return this.currentMove;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * {@inheritDoc}
     *
     * Will throw an {@link IllegalArgumentException} when the input is not a {@link MoveDirection}.
     * It will push the MoveDirection to the {@link InputBuffer} if it is a MoveDirection.
     */
    @Override
    public void pushInput(PlayerInput input) {
        if (input instanceof MoveDirection) {
            inputBuffer.addToInputMoves((MoveDirection) input);
        } else {
            throw new IllegalArgumentException("Input needs to be of the class MoveDirection.");
        }
    }

    /**
     * {@inheritDoc}
     *
     * Updates the PlayerEntity according to the buffered input and the current state of the PlayerEntity.
     */
    @Override
    public void update(Game game, List<Event> eventQueue) {
        currentMove = inputBuffer.getNextInputMove();

        state.handleInput(this, currentMove, game.getMap(), eventQueue);
    }
}
package com.sstengine.player;

import com.sstengine.Game;
import com.sstengine.event.framework.Event;
import com.sstengine.util.Identifiable;

import java.util.List;

/**
 * The Playable interface indicates that an object is controllable by a Player (human or machine).
 * Contains method for updating the underlying object and pushing input to the Playable.
 * <p>
 * Extends the Identifiable interface as every playable object should be identifiable with an id.
 *
 * @author Oscar de Leeuw
 */
public interface Playable extends Identifiable {
    /**
     * Gets the Player that is controlling this Playable.
     *
     * @return The Player that is controlling this Playable.
     */
    Player getPlayer();

    /**
     * Sets the Player that is controlling this Playable.
     *
     * @param player The Player that is now controlling this Playable.
     */
    void setPlayer(Player player);

    /**
     * Updates the Playable.
     *
     * @param game       The game from which the logic can query information.
     * @param eventQueue The queue of events that will be executed by the game.
     */
    void update(Game game, List<Event> eventQueue);

    /**
     * Pushes input to the Playable.
     * Throws an {@link IllegalArgumentException} when the input cannot be processed by the Playable.
     *
     * @param input The PlayerInput that should be pushed to the Playable.
     */
    void pushInput(PlayerInput input);
}

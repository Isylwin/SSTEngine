package com.sstengine.ui;

/**
 * The PlayerUIAction interface is an interface that should be extended by an Enum that defines all the actions a player
 * can perform upon the UI.
 *
 * @author Oscar de Leeuw
 * @param <T> The Enum that implements this interface.
 */
@FunctionalInterface
public interface PlayerUIAction<T extends Enum> {
    /**
     * Gets the action the player wants to perform.
     *
     * @return The action of the player.
     */
    T getAction();
}

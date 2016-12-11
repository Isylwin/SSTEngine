package com.sstengine.ui;

/**
 * The KeyboardKey class that wraps around an object that should represent a keyboard key.
 * This class is used to remain completely decoupled from any UI implementation.
 *
 * @author Oscar de Leeuw
 * @param <T> The key object that is wrapped by this KeyboardKey.
 */
public class KeyboardKey<T> {
    private T keyCode;

    /**
     * Creates a new KeyboardKey.
     *
     * @param wrappedKey The key that is wrapped by this KeyboardKey.
     */
    public KeyboardKey(T wrappedKey) {
        this.keyCode = wrappedKey;
    }

    /**
     * Gets the keyCode that is wrapped by this KeyboardKey.
     *
     * @return The key the player has pressed.
     */
    T getKey() {
        return keyCode;
    }
}

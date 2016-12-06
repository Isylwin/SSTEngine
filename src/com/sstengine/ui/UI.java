package com.sstengine.ui;

import com.sstengine.Game;
import com.sstengine.component.graphics.Painter;
import com.sstengine.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The UI class represents an user interface that a player can interact with.
 * It holds all the {@link UIObject}s that live on the UI and supports sending {@link PlayerUIAction}s to the UI.
 * The UI class does not render graphics itself but relies on a {@link Painter} on which it can draw.
 * This allows the UI class to function regardless of the graphical solution the end user chooses.
 * <p>
 * The UI class is abstract and should be extended in order to create a custom UI.
 *
 * @author Oscar de Leeuw
 */
public abstract class UI {
    protected List<UIObject> uiObjects = new ArrayList<>();
    private Painter painter;
    private Player player;
    private Game game;

    /**
     * Creates a new UI.
     *
     * @param painter The painter that the UI will use for its graphical context.
     * @param game The Game that this UI is observing.
     * @param player The Player that is associated with this UI.
     */
    protected UI(Painter painter, Game game, Player player) {
        this.painter = painter;
        this.game = game;
        this.player = player;
    }

    /**
     * Gets the width of the UI.
     *
     * @return The width of the UI in pixels.
     */
    protected int getWidth() {
        return painter.getWidth();
    }

    /**
     * Gets the height of the UI.
     *
     * @return The height of the UI in pixels.
     */
    protected int getHeight() {
        return painter.getHeight();
    }

    /**
     * Gets the Player that is associated with this UI.
     *
     * @return The Player that is associated with this UI.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the Game that this UI is observing.
     *
     * @return The Game that this UI is observing.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Adds an UIObject to the UI.
     *
     * @param uiObject The UIObject to add.
     */
    protected void addUIObject(UIObject uiObject) {
        uiObjects.add(uiObject);
        uiObjects.sort(UIObject::compareTo);
    }

    /**
     * Sends a PlayerUIAction to the UI.
     *
     * @param action The UI action the player would like to perform.
     */
    public abstract void sendKey(PlayerUIAction action);

    /**
     * Renders the UI.
     */
    public void render() {
        uiObjects.stream().filter(o -> !o.isHidden()).forEach(o -> o.render(painter));
    }
}

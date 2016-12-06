package com.sstengine.ui;

import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.graphics.Painter;

import java.awt.*;

/**
 * The UIObject class represents an object that lives on the UI.
 * <p>
 * <p>
 * UIObject can be extended.
 *
 * @author Oscar de Leeuw
 * @param <T> The Object that is wrapped by the UIObject.
 */
public abstract class UIObject<T> implements Comparable<UIObject> {
    private GraphicsComponent graphics;

    private Rectangle area;
    private boolean hidden;
    private boolean selected;
    private int priority;

    /**
     * Creates an UIObject.
     *
     * @param graphics The graphics that defines how this UIObject is drawn.
     * @param area     The area of this UIObject.
     * @param priority The priority of this UIObject.
     */
    protected UIObject(GraphicsComponent graphics, Rectangle area, int priority) {
        this.graphics = graphics;
        this.area = area;
        this.priority = priority;
    }

    /**
     * Creates an UIObject.
     *
     * @param graphics The graphics that defines how this UIObject is drawn.
     * @param area The area of this UIObject.
     */
    protected UIObject(GraphicsComponent graphics, Rectangle area) {
        this(graphics, area, 1);
    }

    /**
     * Creates an UIObject.
     *
     * @param graphics The graphics that defines how this UIObject is drawn.
     * @param location The location of the UIObject.
     * @param width The width of the UIObject.
     * @param height The height of the UIObject.
     */
    protected UIObject(GraphicsComponent graphics, Point location, int width, int height) {
        this(graphics, new Rectangle(location.x, location.y, width, height), 1);
    }

    /**
     * Creates an UIObject.
     *
     * @param graphics The graphics that defines how this UIObject is drawn.
     * @param location The location of the UIObject.
     * @param width The width of the UIObject.
     * @param height The height of the UIObject.
     * @param priority The priority of the UIObject.
     */
    protected UIObject(GraphicsComponent graphics, Point location, int width, int height, int priority) {
        this(graphics, new Rectangle(location.x, location.y, width, height), priority);
    }

    /**
     * Gets the priority of the UIObject.
     * The priority defines the order of rendering and click handling of UIObjects.
     * @return An integer that represents the priority of the UIObject.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority of the UIObject.
     * @param priority The new priority of the UIObject.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Gets whether this UIObject is hidden or not.
     * An UIObject that is hidden will not be drawn on the GUI.
     * @return True if the UIObject is hidden.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Sets the hidden status of this UIObject.
     * @param value The hidden status of this UIObject.
     */
    public void setHidden(boolean value) {
        this.hidden = value;
    }

    /**
     * Sets whether this UIObject is currently selected.
     * @return True when this UIObject is currently selected.
     */
    public boolean isSelected() {
        return this.selected;
    }

    /**
     * Sets the UIObject is currently selected.
     * @param value The new selection status of this UIObject.
     */
    public void setSelected(boolean value) {
        this.selected = value;
    }

    /**
     * Gets the location of this UIObject in relation to the UI.
     * @return A point that represents the upper-left hand corner of the UIObject.
     */
    public Point getLocation() {
        return this.area.getLocation();
    }

    /**
     * Gets the width of the UIObject.
     * @return An int that represents the width of the UIObject.
     */
    public int getWidth() {
        return this.area.width;
    }

    /**
     * Gets the height of the UIObject.
     * @return An int that represents the height of the UIObject.
     */
    public int getHeight() {
        return this.area.height;
    }

    /**
     * Resizes the UIObject to the given width and height.
     *
     * @param width The new width of the UIObject.
     * @param height The new height of the UIObject.
     */
    public void resize(int width, int height) {
        area.setSize(width, height);
    }

    /**
     * Checks whether the location of a click is within this UIObject.
     * Will only check when this UIObject is not hidden;
     *
     * @param x The x location of the mouse click.
     * @param y The y location of the mouse click.
     * @return True when the UIObject is not hidden and the click within the Rectangle.
     */
    public boolean isClicked(int x, int y) {
        return hidden && area.contains(x, y);
    }

    /**
     * Gets the underlying object that is contained by this UIObject from a click.
     * Changes the incoming arguments to offset them in relation to the location of this UIObject.
     *
     * @param x The X-coordinate of the click.
     * @param y The Y-coordinate of the click.
     * @return The underlying object of this UIObject.
     */
    public T click(int x, int y) {
        int correctedX = x - getLocation().x;
        int correctedY = y - getLocation().y;

        return handleClick(correctedX, correctedY);
    }

    /**
     * Handles the retrieval of the underlying object.
     * Assumes that the given arguments are in relation to the location of the UIObject.
     * @param x The X-coordinate of the click.
     * @param y The Y-coordinate of the click.
     * @return The underlying object of this UIObject.
     */
    protected abstract T handleClick(int x, int y);

    /**
     * Draws this UIObject on the given painter object.
     *
     * @param painter The painter on which the UIObject can be drawn.
     */
    void render(Painter painter) {
        graphics.render(this, painter, getLocation(), getWidth(), getHeight());
    }

    @Override
    public int compareTo(UIObject o) {
        if (priority < o.getPriority()) {
            return -1;
        } else if (priority == o.getPriority()) {
            return 0;
        } else {
            return 1;
        }
    }
}

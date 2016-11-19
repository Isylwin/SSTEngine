package com.sstengine.ui;

import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.graphics.Painter;

import java.awt.*;

//TODO needs doc.

/**
 * The UIObject class represents an object that lives on the UI.
 * <p>
 * <p>
 * UIObject can be extended.
 *
 * @author Oscar de Leeuw
 */
abstract public class UIObject<T> implements Comparable<UIObject> {
    private GraphicsComponent graphics;

    private Rectangle area;
    private boolean hidden;
    private boolean selected;
    private int priority;

    protected UIObject(GraphicsComponent graphics, Rectangle area, int priority) {
        this.graphics = graphics;
        this.area = area;
        this.priority = priority;
    }

    protected UIObject(GraphicsComponent graphics, Rectangle area) {
        this(graphics, area, 1);
    }

    protected UIObject(GraphicsComponent graphics, Point location, int width, int height) {
        this(graphics, new Rectangle(location.x, location.y, width, height), 1);
    }

    protected UIObject(GraphicsComponent graphics, Point location, int width, int height, int priority) {
        this(graphics, new Rectangle(location.x, location.y, width, height), priority);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean value) {
        this.hidden = value;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }

    public Point getLocation() {
        return this.area.getLocation();
    }

    public int getWidth() {
        return this.area.width;
    }

    public int getHeight() {
        return this.area.height;
    }

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

    public T click(int x, int y) {
        int correctedX = x - getLocation().x;
        int correctedY = y - getLocation().y;

        return click(correctedX, correctedY);
    }

    abstract protected T handleClick(int x, int y);

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

package com.sstengine.component.graphics;

import java.awt.*;

/**
 * The GraphicsComponent class represents the graphical part of an object.
 * This means that it will define how an object will be drawn on a {@link Painter}.
 *
 * @author Oscar de Leeuw
 */
public abstract class GraphicsComponent {
    public abstract void render(Object caller, Painter painter, Point location, int width, int height);
}

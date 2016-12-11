package com.sstengine.component.graphics;

import java.awt.*;
import java.io.Serializable;

/**
 * The GraphicsComponent class represents the graphical part of an object.
 * This means that it will define how an object will be drawn on a {@link Painter}.
 *
 * @author Oscar de Leeuw
 */
public abstract class GraphicsComponent implements Serializable {
    /**
     * Renders the GraphicsComponent.
     *
     * @param caller   The object that is calling the render method.
     * @param painter  The Painter on which the graphics can be drawn.
     * @param location A Point that represents the location at which the graphics should be drawn.
     * @param width    The width in pixels that is reserved for the drawing of the graphics.
     * @param height   The height in pixels that is reserved for the drawing of the graphics.
     */
    public void render(Object caller, Painter painter, Point location, int width, int height) {

    }
}

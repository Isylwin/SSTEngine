package com.sstengine.component.graphics;

import java.awt.*;

/**
 * The graphics interface is a contract for all objects that require a graphical representation.
 * Most object that implement Graphics should fulfill this requirement by having a {@link GraphicsComponent}.
 *
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface Graphics {
    /**
     * Renders the object on the given painter on the screen.
     *
     * @param painter  The painter which supports the drawing.
     * @param location The location at which the graphics should be drawn, in pixels.
     * @param width    The maximum width that can be used for drawing the object, in pixels.
     * @param height   The maximum height that can be used for drawing the object, in pixels.
     */
    void render(Painter painter, Point location, int width, int height);
}

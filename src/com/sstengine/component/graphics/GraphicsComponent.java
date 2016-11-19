package com.sstengine.component.graphics;

import java.awt.*;

/**
 * The GraphicsComponent class
 *
 * @author Oscar de Leeuw
 */
public abstract class GraphicsComponent {
    public abstract void render(Object caller, Painter painter, Point location, int width, int height);
}

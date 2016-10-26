package com.sstengine.component.graphics;

/**
 * The GraphicsComponent class
 * Every Object that uses a GraphicsComponent should implement the {@link Graphics} interface.
 *
 * @author Oscar de Leeuw
 */
public abstract class GraphicsComponent {
    public abstract void render(Graphics caller);
}

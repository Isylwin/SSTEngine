package com.sstengine;

import com.sstengine.component.graphics.Graphics;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.graphics.Painter;
import com.sstengine.component.physical.Physical;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.PlayerEntity;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * The GameObject class represents all objects within the game that are physical.
 * All GameObjects must describe a physical component and a graphical component.
 *
 * @author Oscar de Leeuw
 */
public abstract class GameObject implements Physical, Graphics, Serializable {
    private PhysicalComponent physical;
    private GraphicsComponent graphics;

    /**
     * Creates a new GameObject.
     *
     * @param physical The physical component of the GameObject.
     * @param graphics The graphical component of the GameObject.
     */
    protected GameObject(PhysicalComponent physical, GraphicsComponent graphics) {
        this.graphics = graphics;
        this.physical = physical;
    }

    @Override
    public boolean isAccessible(PlayerEntity entity) {
        return physical.isAccessible(this, entity);
    }

    @Override
    public void interactWith(PlayerEntity entity, List<Event> eventQueue) {
        physical.interactWith(this, entity, eventQueue);
    }

    @Override
    public void render(Painter painter, Point location, int width, int height) {
        graphics.render(this, painter, location, width, height);
    }
}

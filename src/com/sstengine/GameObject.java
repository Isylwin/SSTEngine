package com.sstengine;

import com.sstengine.component.graphics.Graphics;
import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.Physical;
import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.event.framework.Event;
import com.sstengine.player.playerentity.PlayerEntity;

import java.util.List;

/**
 * @author Oscar de Leeuw
 */
public abstract class GameObject implements Physical, Graphics {
    private PhysicalComponent physical;
    private GraphicsComponent graphics;

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
    public void render() {
        graphics.render(this);
    }
}

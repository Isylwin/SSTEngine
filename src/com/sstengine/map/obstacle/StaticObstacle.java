package com.sstengine.map.obstacle;

import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.standard.StaticObstaclePhysicalComponent;

/**
 * The StaticObstacle class represents a {@link Obstacle} that is static and can only be created when loading the map.
 * Obstacles are impassable by default.
 *
 * @author Oscar de Leeuw
 */
public class StaticObstacle extends Obstacle {
    private StaticObstacleType type;

    /**
     * Creates a new StaticObstacle.
     *
     * @param graphicsComponent
     * @param type
     */
    public StaticObstacle(GraphicsComponent graphicsComponent, StaticObstacleType type) {
        super(StaticObstaclePhysicalComponent.getInstance(), graphicsComponent);
        this.type = type;
    }
}

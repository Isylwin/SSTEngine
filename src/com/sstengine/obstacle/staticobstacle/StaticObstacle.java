package com.sstengine.obstacle.staticobstacle;

import com.sstengine.component.graphics.GraphicsComponent;
import com.sstengine.component.physical.standard.StaticObstaclePhysicalComponent;
import com.sstengine.obstacle.Obstacle;

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
     * @param graphicsComponent The graphics component of the obstacle, defines how it should be represented graphically.
     * @param type The type of static obstacle.
     */
    public StaticObstacle(GraphicsComponent graphicsComponent, StaticObstacleType type) {
        super(new StaticObstaclePhysicalComponent(), graphicsComponent);
        this.type = type;
    }
}

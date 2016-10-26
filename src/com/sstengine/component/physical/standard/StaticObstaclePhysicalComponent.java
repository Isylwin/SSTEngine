package com.sstengine.component.physical.standard;

import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.strategy.strategies.DefaultAccessibilityStrategy;
import com.sstengine.strategy.strategies.DefaultInteractionStrategy;

/**
 * Physical component implementation that uses {@link DefaultAccessibilityStrategy} and {@link DefaultInteractionStrategy}
 * as accessibility and interaction strategies.
 * <p>
 * This class is a singleton as every static obstacle uses the same code thus we can save memory.
 *
 * @author Oscar de Leeuw
 */
public class StaticObstaclePhysicalComponent extends PhysicalComponent {
    private static StaticObstaclePhysicalComponent ourInstance = new StaticObstaclePhysicalComponent();

    private StaticObstaclePhysicalComponent() {
        super(new DefaultAccessibilityStrategy(), new DefaultInteractionStrategy());
    }

    public static StaticObstaclePhysicalComponent getInstance() {
        return ourInstance;
    }
}


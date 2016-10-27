package com.sstengine.component.physical.standard;

import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.strategy.strategies.DefaultAccessibilityStrategy;
import com.sstengine.strategy.strategies.DefaultInteractionStrategy;

/**
 * Physical component implementation that uses {@link DefaultAccessibilityStrategy} and {@link DefaultInteractionStrategy}
 * as accessibility and interaction strategies.
 *
 * @author Oscar de Leeuw
 */
public class StaticObstaclePhysicalComponent extends PhysicalComponent {
    public StaticObstaclePhysicalComponent() {
        super(new DefaultAccessibilityStrategy(), new DefaultInteractionStrategy());
    }

    //TODO find a way to only make one instance of this per game.
}


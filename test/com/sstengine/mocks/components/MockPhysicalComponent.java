package com.sstengine.mocks.components;

import com.sstengine.component.physical.PhysicalComponent;
import com.sstengine.strategy.AccessibilityStrategy;
import com.sstengine.strategy.InteractionStrategy;

/**
 * @author Oscar de Leeuw
 */
public class MockPhysicalComponent extends PhysicalComponent {

    /**
     * Creates a new PhysicalComponent.
     *
     * @param accessStrategy      The logic that will handle the accessibility of this component.
     * @param interactionStrategy The logic that will handle the interaction between a PlayerEntity and the owner of this component.
     */
    public MockPhysicalComponent(AccessibilityStrategy accessStrategy, InteractionStrategy interactionStrategy) {
        super(accessStrategy, interactionStrategy);
    }
}

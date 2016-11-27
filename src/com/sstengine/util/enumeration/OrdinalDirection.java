package com.sstengine.util.enumeration;

import java.awt.*;

/**
 * The OrdinalDirection enum represents all the cardinal direction and ordinal directions.
 *
 * @author Oscar de Leeuw
 */
public enum OrdinalDirection {
    NORTH, SOUTH, WEST, EAST, NORTHWEST, NORTHEAST, SOUTHWEST, SOUTHEAST;

    static {
        NORTH.cartesian = new Point(0, -1);
        SOUTH.cartesian = new Point(0, 1);
        EAST.cartesian = new Point(1, 0);
        WEST.cartesian = new Point(-1, 0);
        NORTHWEST.cartesian = new Point(WEST.cartesian.x, NORTH.cartesian.y);
        NORTHEAST.cartesian = new Point(EAST.cartesian.x, NORTH.cartesian.y);
        SOUTHWEST.cartesian = new Point(WEST.cartesian.x, SOUTH.cartesian.y);
        SOUTHEAST.cartesian = new Point(EAST.cartesian.x, SOUTH.cartesian.y);
    }

    private Point cartesian;

    /**
     * Gets the cartesian representation of the direction.
     *
     * @return A point with the cartesian representation of the direction.
     */
    public Point getCartesianRepresentation() {
        return this.cartesian;
    }
}

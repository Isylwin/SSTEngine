package com.sstengine.util.enumeration;

import java.awt.*;

/**
 * The CardinalDirection enum holds all the cardinal direction (E, W, N, S).
 * Contains a method to convert a cardinal direction to a point.
 *
 * @author Oscar de Leeuw
 */
public enum CardinalDirection {
    NORTH, SOUTH, WEST, EAST;

    static {
        NORTH.cartesian = new Point(0, -1);
        SOUTH.cartesian = new Point(0, 1);
        EAST.cartesian = new Point(1, 0);
        WEST.cartesian = new Point(-1, 0);
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

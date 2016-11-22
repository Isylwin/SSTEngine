package com.sstengine.player.playerentity;

import com.sstengine.util.enumeration.CardinalDirection;

import java.awt.*;

/**
 * Enum that contains the definitions of all possible movements within the game.
 *
 * @author Oscar de Leeuw
 */
public enum MoveDirection {
    UP, DOWN, LEFT, RIGHT, NONE;

    static {
        UP.cartesianTranslation = CardinalDirection.NORTH.getCartesianRepresentation();
        DOWN.cartesianTranslation = CardinalDirection.SOUTH.getCartesianRepresentation();
        LEFT.cartesianTranslation = CardinalDirection.WEST.getCartesianRepresentation();
        RIGHT.cartesianTranslation = CardinalDirection.EAST.getCartesianRepresentation();
        NONE.cartesianTranslation = new Point(0, 0);
    }

    private Point cartesianTranslation;

    /**
     * Converts a point into the corresponding MoveDirection. The point must represent a direction.
     * Returns NONE when it cannot find a match.
     *
     * @param point The point you want a MoveDirection for.
     * @return The MoveDirection that corresponds with the point.
     */
    public static MoveDirection getMoveDirectionFromPoint(Point point) {
        for (MoveDirection md : MoveDirection.values()) {
            if (point.equals(md.cartesianTranslation)) {
                return md;
            }
        }
        return NONE;
    }

    /**
     * Gets a point that would be the cartesian translation of the movement.
     *
     * @return A point that represents the cartesian translation of the movement.
     */
    public Point getTranslation() {
        return cartesianTranslation;
    }

    /**
     * Gets a point that represents the next location with this MoveDirection.
     *
     * @param location The current location from which should be moved.
     * @return A point that represents the movement of this MoveDirection from the given location.
     */
    public Point getLocationWithMove(Point location) {
        return new Point(location.x + cartesianTranslation.x, location.y + cartesianTranslation.y);
    }
}

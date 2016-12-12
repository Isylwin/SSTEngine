package com.sstengine.component.graphics;



import java.awt.*;
import java.io.File;

/**
 * Painter is an utility for the library to allow graphics of {@link Graphics}s.
 * Painter should be implemented in the UI.
 *
 * @author Oscar de Leeuw
 */
public interface Painter {
    /**
     * Gets the total height of the Painter in pixels.
     *
     * @return The height of the Painter in pixels.
     */
    int getHeight();

    /**
     * Gets the total width of the Painter in pixels.
     *
     * @return The width of the Painter in pixels.
     */
    int getWidth();

    /**
     * Draws an image onto the UI.
     *
     * @param file     The file that contains the image.
     * @param location The location at which the Image should be drawn.
     * @param width    The width of the image.
     * @param height   The height of the image.
     */
    void drawImage(File file, Point location, int width, int height);

    /**
     * Draws a rectangle at the given location.
     *
     * @param location The upper left corner of the rectangle.
     * @param width    The width of the rectangle.
     * @param height   The height of the rectangle.
     * @param color    The color of the rectangle.
     * @param fill     A bool that indicates whether it should be filled or not.
     */
    void drawRectangle(Point location, int width, int height, Color color, boolean fill);

    void drawString(String text, Point location, int width, int height, Color color, boolean fill);

    /**
     * Draws an ellipse at the given location.
     *
     * @param location The upper left corner of the ellipse.
     * @param width    The maximum width of the text.
     * @param height   The height of the text.
     * @param color    The color of the text.
     * @param fill     A boolean that indicates whether the ellipse should be filled or not.
     */
    void drawEllipse(Point location, int width, int height, Color color, boolean fill);
}

package com.sstengine.util;

import java.io.Serializable;

/**
 * An Identifiable is an object that can be identified with an unique ID.
 *
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface Identifiable extends Serializable {
    /**
     * Gets the ID of this object.
     *
     * @return The ID of the object.
     */
    int getId();
}

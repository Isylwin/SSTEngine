package com.sstengine.country;

import java.io.Serializable;

/**
 * The CountryTag interface is an interface that should be implemented by an enum.
 * This enum should represent the possible tags/names a team can have within the game.
 *
 * @author Oscar de Leeuw
 * @param <T> The Enum that implements this interface.
 */
@FunctionalInterface
public interface CountryTag<T extends Enum> extends Serializable {
    /**
     * Gets the tag of the Country.
     *
     * @return The tag of the Country.
     */
    T getTag();
}

package com.sstengine.country;

/**
 * The CountryTag interface is an interface that should be implemented by an enum.
 * This enum should represent the possible tags/names a team can have within the game.
 *
 * @author Oscar de Leeuw
 */
public interface CountryTag<T extends Enum> {
    /**
     * Gets the tag of the Country.
     *
     * @return The tag of the Country.
     */
    T getTag();
}

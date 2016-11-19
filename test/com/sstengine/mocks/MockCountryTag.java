package com.sstengine.mocks;

import com.sstengine.map.country.CountryTag;

/**
 * Mock implementation of the CountryTag interface.
 *
 * @author Oscar de Leeuw
 */
public enum MockCountryTag implements CountryTag<MockCountryTag> {
    MEX, USA;

    public MockCountryTag getTag() {
        return this;
    }
}

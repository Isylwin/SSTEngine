package com.sstengine.country;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Oscar de Leeuw
 */
public class CountryTest {
    private Country countryMex;
    private Country countryUsa;

    @Before
    public void setUp() throws Exception {
        countryMex = new Country(MockCountryTag.MEX);
        countryUsa = new Country(MockCountryTag.USA);
    }

    @Test
    public void getTag() throws Exception {
        assertEquals(MockCountryTag.MEX, countryMex.getTag());
        assertEquals(MockCountryTag.USA, countryUsa.getTag());
    }

    private enum MockCountryTag implements CountryTag<MockCountryTag> {
        MEX,USA;

        public MockCountryTag getTag() {
            return this;
        }
    }

}
package com.sstengine.map.country;

import com.sstengine.mocks.MockCountryTag;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Country class.
 *
 * @author Oscar de Leeuw
 */
public class CountryTest {
    private Country countryMex;
    private Country countryUsa;

    @Before
    public void setUp() throws Exception {
        countryMex = new Country(null, null, MockCountryTag.MEX);
        countryUsa = new Country(null, null, MockCountryTag.USA);
    }

    @Test
    public void getTag() throws Exception {
        assertEquals(MockCountryTag.MEX, countryMex.getTag());
        assertEquals(MockCountryTag.USA, countryUsa.getTag());
    }
}
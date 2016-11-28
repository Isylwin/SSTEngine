package com.sstengine.country;

import com.sstengine.map.tile.Tile;
import com.sstengine.mocks.MockCountryTag;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

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

    @Test
    public void getLand() throws Exception {
        Tile tile = new Tile(1, null, null, new Point(0, 0));
        countryMex.addLand(tile);
        Tile mexLand = countryMex.getLand().get(0);

        assertEquals(tile, mexLand);

        mexLand.setCountry(countryUsa);

        assertEquals(tile.getCountry(), mexLand.getCountry());
    }
}
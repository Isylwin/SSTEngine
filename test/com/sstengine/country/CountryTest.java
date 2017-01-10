package com.sstengine.country;

import com.sstengine.map.tile.Tile;
import com.sstengine.mocks.components.MockClosedAvailStrat;
import com.sstengine.mocks.components.MockNoInteractionStrat;
import com.sstengine.mocks.components.MockOpenAvailStrat;
import com.sstengine.mocks.enumerations.MockCountryTag;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.testutil.TestUtil;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.*;

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
        countryMex = TestUtil.makeCountry(MockCountryTag.MEX, TestUtil.makePhysicalComponent(new MockOpenAvailStrat(), new MockNoInteractionStrat()));
        countryUsa = TestUtil.makeCountry(MockCountryTag.USA, TestUtil.makePhysicalComponent(new MockClosedAvailStrat(), new MockNoInteractionStrat()));
    }

    @Test
    public void getTag() throws Exception {
        assertEquals(MockCountryTag.MEX, countryMex.getTag());
        assertEquals(MockCountryTag.USA, countryUsa.getTag());
    }

    @Test
    public void getLand_WithGivenCountry_ShouldBeEqual() throws Exception {
        Tile tile = new Tile(1, null, null, new Point(0, 0));
        countryMex.addLand(tile);
        Tile mexLand = countryMex.getLand().stream().filter(x -> x == tile).findAny().get();

        assertEquals(tile.getCountry(), mexLand.getCountry());
    }

    @Test
    public void getAccessibleLand_WithOpenCountry_ShouldReturnLand() throws Exception {
        PlayerEntity entity = TestUtil.makePlayerEntity();

        List<Tile> actual = countryMex.getAccessibleLand(entity);
        assertFalse(actual.isEmpty());
        assertTrue(countryMex.getLand().size() > actual.size());
    }

    @Test(expected = IllegalStateException.class)
    public void getAccessibleLand_WithClosedCountry_ThrowsException() throws Exception {
        PlayerEntity entity = TestUtil.makePlayerEntity();

        List<Tile> actual = countryUsa.getAccessibleLand(entity);
        assertTrue(false);
    }
}
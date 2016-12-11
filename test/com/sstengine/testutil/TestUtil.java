package com.sstengine.testutil;

import com.sstengine.component.physical.standard.StaticObstaclePhysicalComponent;
import com.sstengine.country.Country;
import com.sstengine.map.Map;
import com.sstengine.map.tile.Tile;
import com.sstengine.mocks.MockCountryTag;
import com.sstengine.mocks.MockTileType;
import com.sstengine.player.Player;
import com.sstengine.player.playerentity.PlayerEntity;
import com.sstengine.team.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Oscar de Leeuw
 */
public class TestUtil {

    public static Map makeMap(int width, int height) {
        Tile[][] tiles = new Tile[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new Tile(y + (x * height), null, MockTileType.DIRT, new Point(x, y));
            }
        }

        return new Map.Builder("test").setHeight(height).setWidth(width).setTiles(tiles).build();
    }

    public static List<Team> makeTeams(Map map) {
        List<Team> ret = new ArrayList<>();

        List<Tile> usaLand = map.getTiles(t -> t.getLocation().y >= 8);
        List<Tile> mexLand = map.getTiles(t -> t.getLocation().y <= 1);

        ret.add(makeTeam(1, makeCountry(MockCountryTag.USA, usaLand)));
        ret.add(makeTeam(2, makeCountry(MockCountryTag.MEX, mexLand)));

        return ret;
    }

    public static Team makeTeam(int id, Country country) {
        return new Team(id, country);
    }

    public static Country makeCountry(MockCountryTag tag, List<Tile> land) {
        Country country = new Country(null, null, tag);
        land.forEach(country::addLand);

        return country;
    }

    public static Player makePlayer(int id, String name, Team team) {
        return new Player(id, name, team, makePlayerEntity());
    }

    public static PlayerEntity makePlayerEntity() {
        return new PlayerEntity(new StaticObstaclePhysicalComponent(), null);
    }
}

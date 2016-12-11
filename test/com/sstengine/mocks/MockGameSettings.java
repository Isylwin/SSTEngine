package com.sstengine.mocks;

import com.sstengine.game.GameSettings;

/**
 * @author Oscar de Leeuw
 */
public class MockGameSettings implements GameSettings {
    @Override
    public int getScoreLimit() {
        return 20;
    }

    @Override
    public void setScoreLimit(int value) {

    }

    @Override
    public int getTimeLimit() {
        return 500;
    }

    @Override
    public void setTimeLimit(int value) {

    }
}

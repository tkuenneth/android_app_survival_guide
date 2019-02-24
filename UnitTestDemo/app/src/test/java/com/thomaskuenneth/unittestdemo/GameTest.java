package com.thomaskuenneth.unittestdemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void initialize() {
        game = new Game();
    }

    @Test
    public void testMax() {
        Assert.assertTrue(1 <= game.getMax(Game.Difficulty.EASY));
        Assert.assertTrue(1 <= game.getMax(Game.Difficulty.MEDIUM));
        Assert.assertTrue(1 <= game.getMax(Game.Difficulty.HARD));

        Assert.assertTrue(game.getMax(Game.Difficulty.EASY) < game.getMax(Game.Difficulty.MEDIUM));
        Assert.assertTrue(game.getMax(Game.Difficulty.MEDIUM) < game.getMax(Game.Difficulty.HARD));
    }

    @Test
    public void easy() {
        game.setup(Game.Difficulty.EASY);
        int n = game.peek();
        Assert.assertTrue(1 <= n);
        Assert.assertTrue(n <= game.getMax(Game.Difficulty.EASY));
    }
}

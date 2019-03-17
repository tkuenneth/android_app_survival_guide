package com.thomaskuenneth.unittestdemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {

    private static Game game;

    @BeforeClass
    public static void initialize() {
        System.out.println("Setup game");
        game = new Game();
    }

    @AfterClass
    public static void finished() {
        System.out.println("Done");
    }

    @Before
    public void begin() {
        System.out.println("Begin");
    }

    @After
    public void end() {
        System.out.println("End");
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

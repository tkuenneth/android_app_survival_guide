package com.thomaskuenneth.unittestdemo;

public class Game {

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }

    private int number;
    private Difficulty difficulty;

    public void setup(Difficulty difficulty) {
        this.difficulty = difficulty;
        randomNumber();
    }

    public float getMax(Game.Difficulty difficulty) {
        float max;
        switch (difficulty) {
            case EASY:
                max = 3f;
                break;
            case MEDIUM:
                max = 5f;
                break;
            default:
                max = 10f;
                break;
        }
        return max;
    }

    public boolean guess(int guess) {
        return number == guess;
    }

    private void randomNumber() {
        number = 1 + (int) (Math.random() * getMax(difficulty));
    }
}

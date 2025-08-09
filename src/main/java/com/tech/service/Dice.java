package com.tech.service;

import java.util.Random;

public class Dice {

    private static final int MIN_DICE_NUMBER = 1;
    private static final int MAX_DICE_NUMBER = 7;
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

}

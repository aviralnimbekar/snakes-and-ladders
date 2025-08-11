package com.tech;

import com.tech.service.Game;

public class SnakesAndLadders {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        System.out.println("Welcome to the Snakes and Ladders game!!!");
        System.out.println("-----------------------------------------\n");
        Game game = new Game();
        game.start();

    }
}
package com.tech.service;

import com.tech.model.Board;
import com.tech.model.Player;

public class Game {

    private final Dice dice;
    private final Board board;
    private final Player player;

    public Game() {
        this.dice = new Dice();
        this.board = new Board();
        this.player = new Player("player 1");
    }

    public void start() {
        System.out.println(player.getName() + " starting the game at position 00 \n");

        while (board.hasReachedFinalCell()) {
            //Simulating user input with dice roll
            // as this is single player game
            int diceOutcome = dice.roll();

            player.move(diceOutcome);

            board.updateBoard(player);
        }
    }
}

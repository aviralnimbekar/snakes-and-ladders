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
        this.player = new Player();
    }
}

package service;

import model.Board;

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

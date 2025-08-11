package com.tech.model;

import java.util.Map;

public class Board {
    private static final int BOARD_SIZE = 100;
    private final Map<Integer, Integer> ladders;
    private final Map<Integer, Integer> snakes;
    private int playerOnCell;

    public Board() {
        this.ladders = defineLadders();
        this.snakes = defineSnakes();
    }

    public void updateBoard(Player player) {
        int playerPositionOnBoard = updatePositionForSnakeOrLadderIfAny(player);

        if (playerPositionOnBoard > BOARD_SIZE) {
            player.updatePosition(playerOnCell);
        } else {
            playerOnCell = playerPositionOnBoard;
        }

        System.out.println("Player's position on the board :: " + playerOnCell + "\n");
        if (player.getPosition() == BOARD_SIZE) {
            System.out.println("Congratulations " + player.getName() + " you have won the game!!!");
        }
    }

    private int updatePositionForSnakeOrLadderIfAny(Player player) {
        int newPositionOnBoard = player.getPosition();

        if (ladders.containsKey(newPositionOnBoard)) {
            newPositionOnBoard = ladders.get(newPositionOnBoard);
            System.out.println("Yay you landed on a ladder");
            System.out.println("Please move to :: " + newPositionOnBoard);
        }

        if (snakes.containsKey(newPositionOnBoard)) {
            newPositionOnBoard = snakes.get(newPositionOnBoard);
            System.out.println("Be careful you landed on a snake!!!");
            System.out.println("Please move to :: " + newPositionOnBoard);
        }

        player.updatePosition(newPositionOnBoard);
        return newPositionOnBoard;
    }

    public boolean hasReachedFinalCell() {
        return playerOnCell < BOARD_SIZE;
    }

    private Map<Integer, Integer> defineSnakes() {
        return Map.of(
                36, 19,
                65, 35,
                87, 32,
                97, 21
        );
    }

    private Map<Integer, Integer> defineLadders() {
        return Map.of(
                7, 33,
                37, 85,
                51, 72,
                63, 99
        );
    }

}

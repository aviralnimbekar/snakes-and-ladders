package com.tech.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void shouldMovePlayerToGivenPosition() {
        Player player = new Player("test player");

        int nextPosition = 5;
        player.move(nextPosition);

        assertEquals(5, player.getPosition());
    }

    @Test
    void shouldAddPlayersNextPosition() {
        Player player = new Player("test player");
        player.move(8);

        int nextPosition = 5;
        player.move(nextPosition);


        int expectedPosition = 13;
        assertEquals(expectedPosition, player.getPosition());
    }

    @Test
    void shouldSubtractPlayersNextPositionWhenProvidedNegative() {
        Player player = new Player("test player");
        player.move(8);

        int nextPosition = -2;
        player.move(nextPosition);


        int expectedPosition = 6;
        assertEquals(expectedPosition, player.getPosition());
    }
}
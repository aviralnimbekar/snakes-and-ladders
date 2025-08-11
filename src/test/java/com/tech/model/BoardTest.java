package com.tech.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BoardTest {

    @ParameterizedTest
    @CsvSource(value = {"7, 33", "37, 85", "51, 72", "63, 99"}, delimiter = ',')
    void shouldUpdateBoardWithPlayerPositionWhenLandsOnLadder(int foot, int top) throws NoSuchFieldException, IllegalAccessException {
        Field boardCurrentPosition = Board.class.getDeclaredField("currentPosition");
        boardCurrentPosition.setAccessible(true);

        Player mockedPlayer = Mockito.mock(Player.class);
        when(mockedPlayer.getPosition()).thenReturn(foot);

        Board board = new Board();
        board.updateBoard(mockedPlayer);

        assertEquals(top, boardCurrentPosition.get(board));
    }

    @ParameterizedTest
    @CsvSource(value = {"36, 19", "65, 35", "87, 32", "97, 21"}, delimiter = ',')
    void shouldUpdateBoardWithPlayerPositionWhenLandsOnSnake(int head, int tail) throws NoSuchFieldException, IllegalAccessException {
        Field boardCurrentPosition = Board.class.getDeclaredField("currentPosition");
        boardCurrentPosition.setAccessible(true);

        Player mockedPlayer = Mockito.mock(Player.class);
        when(mockedPlayer.getPosition()).thenReturn(head);

        Board board = new Board();
        board.updateBoard(mockedPlayer);

        assertEquals(tail, boardCurrentPosition.get(board));
    }

    @Test
    void shouldUpdateBoardWithPlayerPositionWhenExceedingBoardBoundary() throws NoSuchFieldException, IllegalAccessException {
        Field boardCurrentPosition = Board.class.getDeclaredField("currentPosition");
        boardCurrentPosition.setAccessible(true);

        Player mockedPlayer = Mockito.mock(Player.class);
        when(mockedPlayer.getPosition()).thenReturn(101);

        Board board = new Board();
        boardCurrentPosition.set(board, 98); // Simulating a position before exceeding the board size
        board.updateBoard(mockedPlayer);

        int expectedPositionOnBoard = 98;
        assertEquals(expectedPositionOnBoard, boardCurrentPosition.get(board));
    }

    @Test
    void shouldUpdateBoardWithPlayerPosition() throws NoSuchFieldException, IllegalAccessException {
        Field boardCurrentPosition = Board.class.getDeclaredField("currentPosition");
        boardCurrentPosition.setAccessible(true);

        Player mockedPlayer = Mockito.mock(Player.class);
        when(mockedPlayer.getPosition()).thenReturn(1);

        Board board = new Board();
        board.updateBoard(mockedPlayer);

        int expectedPositionOnBoard = 1;
        assertEquals(expectedPositionOnBoard, boardCurrentPosition.get(board));
    }

    @ParameterizedTest
    @ValueSource(ints = {99, 69, 23})
    void shouldReturnTrueWhenGameContinues(int boardPosition) throws NoSuchFieldException, IllegalAccessException {
        Field boardCurrentPosition = Board.class.getDeclaredField("currentPosition");
        boardCurrentPosition.setAccessible(true);

        Board board = new Board();
        boardCurrentPosition.set(board, boardPosition); // Simulating a position equal to the board size
        boolean isGameContinue = board.isGameContinue();

        assertTrue(isGameContinue);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 101, 159})
    void shouldReturnFalseWhenGameCompleted(int boardPosition) throws NoSuchFieldException, IllegalAccessException {
        Field boardCurrentPosition = Board.class.getDeclaredField("currentPosition");
        boardCurrentPosition.setAccessible(true);

        Board board = new Board();
        boardCurrentPosition.set(board, boardPosition); // Simulating a position equal to the board size
        boolean isGameContinue = board.isGameContinue();

        assertFalse(isGameContinue);
    }

    @Test
    void shouldReturnBoardSize() throws NoSuchFieldException, IllegalAccessException {
        Field boardCurrentPosition = Board.class.getDeclaredField("BOARD_SIZE");
        boardCurrentPosition.setAccessible(true);

        Board board = new Board();

        int expectedBoardSize = 100;
        assertEquals(expectedBoardSize, boardCurrentPosition.get(board));
    }
}
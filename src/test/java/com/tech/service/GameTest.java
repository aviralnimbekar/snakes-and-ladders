package com.tech.service;

import com.tech.model.Board;
import com.tech.model.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    @Test
    void shouldHaveDiceWhenGameConstructed() throws NoSuchFieldException, IllegalAccessException {
        Field gameDice = Game.class.getDeclaredField("dice");
        gameDice.setAccessible(true);

        Game game = new Game();

        assertNotNull(gameDice.get(game));
    }

    @Test
    void shouldRollDice() throws NoSuchFieldException, IllegalAccessException {
        Field gameDice = Game.class.getDeclaredField("dice");
        gameDice.setAccessible(true);
        Field gameBoard = Game.class.getDeclaredField("board");
        gameBoard.setAccessible(true);

        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(4);

        Board board = mock(Board.class);
        when(board.hasReachedFinalCell())
                .thenReturn(true) // 1st call
                .thenReturn(false); // 2nd call

        Game game = new Game();
        gameDice.set(game, dice);
        gameBoard.set(game, board);

        game.start();

        verify(dice, times(1)).roll();
    }

    @Test
    void shouldHaveBoardWhenGameConstructed() throws NoSuchFieldException, IllegalAccessException {
        Field gameBoard = Game.class.getDeclaredField("board");
        gameBoard.setAccessible(true);

        Game game = new Game();

        assertNotNull(gameBoard.get(game));
    }

    @Test
    void shouldMovePlayer() throws NoSuchFieldException, IllegalAccessException {
        Field gameDice = Game.class.getDeclaredField("dice");
        gameDice.setAccessible(true);
        Field gameBoard = Game.class.getDeclaredField("board");
        gameBoard.setAccessible(true);
        Field gamePlayer = Game.class.getDeclaredField("player");
        gamePlayer.setAccessible(true);

        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(4);

        Board board = mock(Board.class);
        when(board.hasReachedFinalCell())
                .thenReturn(true) // 1st call
                .thenReturn(false); // 2nd call

        Player player = mock(Player.class);
        doNothing().when(player).move(4);

        Game game = new Game();
        gameDice.set(game, dice);
        gameBoard.set(game, board);
        gamePlayer.set(game, player);

        game.start();

        verify(player, times(1)).move(4);
    }

    @Test
    void shouldHavePlayerWhenGameConstructed() throws NoSuchFieldException, IllegalAccessException {
        Field gamePlayer = Game.class.getDeclaredField("player");
        gamePlayer.setAccessible(true);

        Game game = new Game();

        assertNotNull(gamePlayer.get(game));
    }

    @Test
    void shouldUpdateBoard() throws NoSuchFieldException, IllegalAccessException {
        Field gameDice = Game.class.getDeclaredField("dice");
        gameDice.setAccessible(true);
        Field gameBoard = Game.class.getDeclaredField("board");
        gameBoard.setAccessible(true);
        Field gamePlayer = Game.class.getDeclaredField("player");
        gamePlayer.setAccessible(true);

        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(4);

        Board board = mock(Board.class);
        when(board.hasReachedFinalCell())
                .thenReturn(true) // 1st call
                .thenReturn(false); // 2nd call

        Player player = mock(Player.class);
        doNothing().when(player).move(anyInt());

        Game game = new Game();
        gameDice.set(game, dice);
        gameBoard.set(game, board);
        gamePlayer.set(game, player);

        game.start();

        verify(board, times(1)).updateBoard(player);
    }
}

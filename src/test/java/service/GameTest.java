package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldHaveBoardWhenGameConstructed() throws NoSuchFieldException, IllegalAccessException {
        Field gameBoard = Game.class.getDeclaredField("board");
        gameBoard.setAccessible(true);

        Game game = new Game();

        assertNotNull(gameBoard.get(game));
    }

    @Test
    void shouldHavePlayerWhenGameConstructed() throws NoSuchFieldException, IllegalAccessException {
        Field gamePlayer = Game.class.getDeclaredField("player");
        gamePlayer.setAccessible(true);

        Game game = new Game();

        assertNotNull(gamePlayer.get(game));
    }
}

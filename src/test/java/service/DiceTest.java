package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @Test
    void shouldNeverRollADiceWithZero() {
        Dice dice = new Dice();

        int actualRoll = dice.roll();

        assertNotEquals(0, actualRoll);
    }

    @Test
    void shouldGenerateARandomNumberBetweenOneToSix() {
        Dice dice = new Dice();

        int actualRoll = dice.roll();

        assertTrue(1 <= actualRoll  && actualRoll <= 6);
    }

    @Test
    void shouldNotGenerateARandomNumberOtherThanOneToSix() {
        Dice dice = new Dice();

        int actualRoll = dice.roll();

        assertFalse(actualRoll < 1 && 6 < actualRoll );
    }
}

package e245742_e245745_e245750;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {

    @Test
    void testCheckGuess_allHit() {
        // Arrange
        Player current = new Player("Player1");
        Player opponent = new Player("Player2");
        current.setNumber(new int[]{1, 2, 3});
        opponent.setNumber(new int[]{1, 2, 3});

        // Act
        current.setGuesses(new int[]{1, 2, 3});
        JudgementResult result = Judgement.checkGuess(current.getGuesses(), current, opponent);

        // Assert
        assertEquals(3, result.getHit(), "All numbers and positions should match (hit=3).");
        assertEquals(0, result.getBlow(), "No numbers should only match in value (blow=0).");
    }

    @Test
    void testCheckGuess_partialHitAndBlow() {
        // Arrange
        Player current = new Player("Player1");
        Player opponent = new Player("Player2");
        current.setNumber(new int[]{1, 2, 3});
        opponent.setNumber(new int[]{1, 3, 2});

        // Act
        current.setGuesses(new int[]{1, 2, 3});
        JudgementResult result = Judgement.checkGuess(current.getGuesses(), current, opponent);

        // Assert
        assertEquals(1, result.getHit(), "Only one number and position should match (hit=1).");
        assertEquals(2, result.getBlow(), "Two numbers should match in value but not position (blow=2).");
    }

    @Test
    void testCheckGuess_noHitOrBlow() {
        // Arrange
        Player current = new Player("Player1");
        Player opponent = new Player("Player2");
        current.setNumber(new int[]{4, 5, 6});
        opponent.setNumber(new int[]{1, 2, 3});

        // Act
        current.setGuesses(new int[]{4, 5, 6});
        JudgementResult result = Judgement.checkGuess(current.getGuesses(), current, opponent);

        // Assert
        assertEquals(0, result.getHit(), "No numbers or positions should match (hit=0).");
        assertEquals(0, result.getBlow(), "No numbers should only match in value (blow=0).");
    }

    @Test
    void testCheckGuess_allBlow() {
        // Arrange
        Player current = new Player("Player1");
        Player opponent = new Player("Player2");
        current.setNumber(new int[]{1, 2, 3});
        opponent.setNumber(new int[]{3, 1, 2});

        // Act
        current.setGuesses(new int[]{1, 2, 3});
        JudgementResult result = Judgement.checkGuess(current.getGuesses(), current, opponent);

        // Assert
        assertEquals(0, result.getHit(), "No numbers should match in both value and position (hit=0).");
        assertEquals(3, result.getBlow(), "All numbers should match in value but not position (blow=3).");
    }
}



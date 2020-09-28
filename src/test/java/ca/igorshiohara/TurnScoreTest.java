package ca.igorshiohara;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnScoreTest {

    @Test
    public void scoreShouldMatch() {
        TurnScore score = new TurnScore(2, 3);
        assertEquals(5, score.getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFirstKnockedIsGreaterThanPins_throwAnError() {
        new TurnScore(12, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFirstKnockedIsLesserThanPins_throwAnError() {
        new TurnScore(-1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSecondKnockedIsGreaterThanPins_throwAnError() {
        new TurnScore(2, 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSecondKnockedIsLesserThanPins_throwAnError() {
        new TurnScore(2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSumOfPinsAreGreaterThan10_throwAnError() {
        new TurnScore(2, 10);
    }

}

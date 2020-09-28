package ca.igorshiohara;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void getScores_whenOneTurn_returnSumOfPins() {
        Board board = new Board();
        board.addShot(new TurnScore(3, 5));

        assertEquals(8, board.getScores());
    }

    @Test
    public void getScores_whenLastOneWasStrike_returnCorrectScore() {
        Board board = new Board();
        board.addShot(new TurnScore(10, 0));
        board.addShot(new TurnScore(3, 6));

        assertEquals(28, board.getScores());
    }

    @Test
    public void getScores_whenLastOneWasSpare_returnCorrectScore() {
        Board board = new Board();
        board.addShot(new TurnScore(7, 3));
        board.addShot(new TurnScore(4, 2));

        assertEquals(20, board.getScores());
    }

}

package ca.igorshiohara;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<TurnScore> scores;

    public Board() {
        scores = new ArrayList<>();
    }

    public void addShot(TurnScore score) {
        scores.add(score);
    }

    public int getScores() {
        if (scores.size() == 1) {
            return scores.stream()
                         .mapToInt(TurnScore::getScore)
                         .sum();
        }

        for (int i = 1; i <= scores.size(); i++) {
            final TurnScore priorShot = scores.get(i - 1);
            final TurnScore currentShot = scores.get(i);

            if (priorShot.isStrike()) {
                priorShot.setScore(currentShot.getFirstKnockedPin() + currentShot.getSecondKnockedPin());
            }
            if (priorShot.isSpare()) {
                priorShot.setScore(currentShot.getFirstKnockedPin());
            }
        }

        return scores.stream()
                     .mapToInt(TurnScore::getScore)
                     .sum();
    }

}

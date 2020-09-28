package ca.igorshiohara;

public class TurnScore {

    private int score;
    private int firstKnockedPin;
    private int secondKnockedPin;
    private boolean isStrike;
    private boolean isSpare;

    public TurnScore(int firstKnockedPin, int secondKnockedPin) {
        basicValidations(firstKnockedPin);
        basicValidations(secondKnockedPin);

        this.firstKnockedPin = firstKnockedPin;
        this.secondKnockedPin = secondKnockedPin;

        secondShotValidations();

        if (firstKnockedPin == 10) {
            isStrike = true;
        }

        if (firstKnockedPin != 10 && firstKnockedPin + secondKnockedPin == 10) {
            isSpare = true;
        }

        score = firstKnockedPin + secondKnockedPin;
    }

    private void secondShotValidations() {
        if (firstKnockedPin + secondKnockedPin > 10) {
            throw new IllegalArgumentException("Sum of shots cannot be greater than 10.");
        }
    }

    private void basicValidations(int numPins) {
        if (numPins > 10) {
            throw new IllegalArgumentException("Cannot set pin greater than 10.");
        }
        if (numPins < 0) {
            throw new IllegalArgumentException("Cannot be negative numbers.");
        }
    }

    public int getFirstKnockedPin() {
        return firstKnockedPin;
    }

    public int getSecondKnockedPin() {
        return secondKnockedPin;
    }

    public void setScore(int newScore) {
        score = score + newScore;
    }
    public int getScore() {
        return score;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }
}


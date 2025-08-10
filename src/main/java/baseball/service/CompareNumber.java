package baseball.service;

import baseball.domain.gameResult;
import baseball.domain.randomNumber;

public class CompareNumber {
    private int ball;
    private int strike;
    private boolean isCorrect;

    public CompareNumber() {
        this.ball = 0;
        this.strike = 0;
        this.isCorrect = false;
    }

    public boolean compare(String compareNumber, String chooseNumber) {

        if (compareNumber == null || chooseNumber == null) {
            return false;
        }
        for (int i = 0; i < compareNumber.length(); i++) {
            char com = compareNumber.charAt(i);
            char ch = chooseNumber.charAt(i);

            if (ch == com) {
                strike++;
            } else if (compareNumber.contains(String.valueOf(ch))) {
                ball++;
            }
        }
        return true;
    }


    public String compareResult() {

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball + gameResult.ball.getMessage());
        }
        if (strike > 0) {
            if (ball > 0) sb.append(" ");
            sb.append(strike + gameResult.strike.getMessage());
        }
        if (ball == 0 && strike == 0) {
            sb.append(gameResult.nothing.getMessage());
        }
        isCorrect = (strike == randomNumber.size.getNumber());
        ball = 0;
        strike = 0;
        return sb.toString();
    }

    public void initBallAndStrike() {
        ball = 0;
        strike = 0;
        isCorrect = false;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}

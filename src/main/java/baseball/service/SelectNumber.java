package baseball.service;

import baseball.comment;
import baseball.endGame;
import baseball.gameResult;
import baseball.randomNumber;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class SelectNumber {
    private boolean isCorrect;
    private int min;
    private int max;
    private int size;
    private final String regex = "^[1-9]{3}$";

    public SelectNumber(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }

    public String pickRandomNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(Randoms.pickUniqueNumbersInRange(min, max, size));
        return sb.toString();
    }

    public String chooseNumber () {
        String number = Console.readLine();
        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public String compareNumber(String compareNumber, String chooseNumber) {
        if (compareNumber.length() != chooseNumber.length()) {
            throw new IllegalArgumentException("비교하는 숫자의 길이가 맞지 않아용");
        }
        int ball = 0;
        int strike = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compareNumber.length(); i++) {
            char com = compareNumber.charAt(i);
            char ch = chooseNumber.charAt(i);

            if (ch == com) {
                strike++;
            } else if (compareNumber.contains(String.valueOf(ch))) {
                ball++;
            }
        }

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
        return sb.toString();
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public boolean maintainGame() {
        String number = Console.readLine();
        if (number.charAt(0) == endGame.maintain.getNumber()) {
            return true;
        }
        else if (number.charAt(0) == endGame.end.getNumber()) {
            return false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

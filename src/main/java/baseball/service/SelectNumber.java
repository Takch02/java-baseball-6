package baseball.service;

import baseball.domain.endGame;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class SelectNumber {

    private int min;
    private int max;
    private int size;
    private String regex = "^[1-9]{3}$";

    public SelectNumber(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }

    /**
     * list -> String
     */
    public String pickRandomNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            sb.append(randomNumber);
        }
        String result = sb.toString();
        if (isValidNumber(result) == false) {
            return null;
        }
        return result;
    }

    /**
     * 예외 발생 시 null 반환
     */
    public String chooseNumber () {
        String number = Console.readLine();
        if (isValidNumber(number) == false) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    private boolean isValidNumber(String number) {

        if (Pattern.matches(regex, number) == false || isDuplicateNumber(number) == false) {
            return false;
        }
        return true;
    }

    /**
     * 문자열 비교 로직
     */
    private boolean isDuplicateNumber(String number) {

        for (char c : number.toCharArray()) {
            int count = 0;
            for (char d : number.toCharArray()) {
                if (c == d) {
                    count++;
                }
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isEndGame() {
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

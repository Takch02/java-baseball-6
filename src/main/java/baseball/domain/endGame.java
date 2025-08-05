package baseball.domain;

public enum endGame {

    maintain('1'), end('2');

    private char number;

    endGame(char number) {
        this.number = number;
    }
    public char getNumber() {
        return number;
    }
}

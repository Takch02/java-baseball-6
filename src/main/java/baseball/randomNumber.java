package baseball;

public enum randomNumber {

    min(1), max(9), size(3);

    private int number;

    randomNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}

package baseball.domain;

public enum gameResult {

    ball("볼"),
    strike("스트라이크"),
    nothing("낫싱"),
    allStrike("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    ;

    private String message;

    gameResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

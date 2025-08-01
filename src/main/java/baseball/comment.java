package baseball;

public enum comment {
    start("숫자 야구 게임을 시작합니다."),
    computerNumber("컴퓨터가 선택한 숫자"),
    input("숫자를 입력해주세요 : "),
    endGame("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ;

    private String message;

    comment(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}

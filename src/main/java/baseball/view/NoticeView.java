package baseball.view;

import baseball.domain.comment;
import baseball.domain.gameResult;

public class NoticeView {
    public void startComment() {
        System.out.println(comment.start.getMessage());
    }

    public void chooseComment() {
        System.out.println(comment.input.getMessage());
    }

    public void endComment() {
        System.out.println(gameResult.allStrike.getMessage());
        System.out.println(comment.endGame.getMessage());
    }

    public void computerNumberComment(String number) {
        if (number == null) {
            System.out.println("컴퓨터가 선택한 숫자가 null 값입니다");
        }
        else {
            System.out.println(comment.computerNumber.getMessage() + " : " + number);
        }
    }

    public void errorComment() {
        System.out.println(comment.errorNumber.getMessage());
    }
    public void resultComment(String result) {
        System.out.println(result);
    }
}

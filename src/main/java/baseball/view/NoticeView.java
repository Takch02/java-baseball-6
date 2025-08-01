package baseball.view;

import baseball.comment;
import baseball.gameResult;

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
        System.out.println(comment.computerNumber.getMessage() + " : " + number);
    }
    public void resultComment(String result) {
        System.out.println(result);
    }
}

package baseball.controller;

import baseball.service.SelectNumber;
import baseball.randomNumber;
import baseball.view.NoticeView;

public class StartGame {

    private boolean isEnd = false;
    NoticeView view = new NoticeView();
    SelectNumber input = new SelectNumber(randomNumber.min.getNumber(), randomNumber.max.getNumber(), randomNumber.size.getNumber());

    public void startGame() {
        view.startComment();  // 시작 멘트
        while(!isEnd) {
            startOneGame();
            if (input.maintainGame() != true) {
                isEnd = true;
            }
        }

    }

    private void startOneGame() {

        String computerNumber = input.pickRandomNumber();
        view.computerNumberComment(computerNumber);
        while (true) {
            view.chooseComment();
            String inputNumber = input.chooseNumber();
            String result = input.compareNumber(computerNumber, inputNumber);
            view.resultComment(result);
            if (input.isCorrect() == true) {
                view.endComment();  // 종료 멘트
                break;
            }
        }
    }
}

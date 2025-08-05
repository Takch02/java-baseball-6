package baseball.controller;

import baseball.service.CompareNumber;
import baseball.service.SelectNumber;
import baseball.domain.randomNumber;
import baseball.view.NoticeView;

public class GameController {

    private boolean isEnd = false;
    NoticeView view = new NoticeView();
    SelectNumber input = new SelectNumber(randomNumber.min.getNumber(), randomNumber.max.getNumber(), randomNumber.size.getNumber());
    CompareNumber compareNumber = new CompareNumber();

    public void startGame() {
        view.startComment();  // 시작 멘트
        while(!isEnd) {
            try {
                startOneGame();
                if (input.isEndGame() != true) {
                    isEnd = true;
                }
            } catch (IllegalArgumentException e) {
                view.errorComment();
                isEnd = true;  // 숫자 형식이 잘못되면 바로 종료
            }
        }

    }

    private void startOneGame() {

        String computerNumber = input.pickRandomNumber();
        view.computerNumberComment(computerNumber);
        while (true) {
            try {
                view.chooseComment();
                String inputNumber = input.chooseNumber();
                if (compareNumber.compare(computerNumber, inputNumber) == false) {
                    view.errorComment();
                    continue;
                }
                String result = compareNumber.compareResult();
                view.resultComment(result);

                if (compareNumber.getIsCorrect() == true) {
                    compareNumber.initBallAndStrike();  // 객체 재활용을 위한 초기화
                    view.endComment();  // 종료 멘트
                    break;
                }
            } catch(IllegalArgumentException e) {
                view.errorComment();
            }
        }
    }
}

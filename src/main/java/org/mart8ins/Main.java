package org.mart8ins;


import java.math.BigDecimal;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int gameQuestionsLimit = 2;
        int questonsAnswered = 0;
        boolean gameContinues = true;

        System.out.println("Welcome to trivia!");
        System.out.println("Please select type of trivia game you want to play.");
        System.out.println("1 - random TRIVIA, 2 - random YEAR trivia, 3 - random DATE trivia, 4 - random MATH trivia");

        String triviaType = GameType.getTriviaType();
        Set<String> questions = null;
        try {
            questions = FetchTriviaQuestions.getTriviaQuestion(triviaType, gameQuestionsLimit);
        } catch (FailedToFetchQuestions e) {
            System.out.println(e.getMessage());
        }

        TriviaGame triviaGame = new TriviaGame(questions);
        while(gameContinues) {
            boolean correctAnswer = triviaGame.playTriviaRound();
            if(correctAnswer) {
                questonsAnswered++;
            } else {
                BigDecimal answerWas = triviaGame.getCorrectAnswer();
                System.out.println("Game over, you lost. Correct answer was: " + answerWas + ". You answered " + questonsAnswered + " from " + gameQuestionsLimit + " questions.");
                gameContinues = false;
            }
            if(questonsAnswered == gameQuestionsLimit){
                gameContinues = false;
                System.out.println("Congratulations! You finished the game and answered to all " + gameQuestionsLimit + " questions");
            }
        }
    }
}
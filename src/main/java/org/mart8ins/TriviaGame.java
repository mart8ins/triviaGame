package org.mart8ins;

import java.math.BigDecimal;
import java.util.*;

public class TriviaGame {
    private List<String> allQuestions = new ArrayList<>();
    private String currentQuestion;
    private BigDecimal[] currentAnswers = new BigDecimal[3];
    private BigDecimal currentCorrectAnswer;

    public TriviaGame(Set<String> questions) {
        for(String s: questions) {
            allQuestions.add(s);
        }
    }

    public boolean playTriviaRound(){
        Scanner in = new Scanner(System.in);
        String questionToRemoveAndFormat = allQuestions.remove(0);
        formatQuestionAndAnswers(questionToRemoveAndFormat);

        System.out.println("* " + currentQuestion);
        System.out.println("Possible answers: ");
        for(int i = 0; i < currentAnswers.length; i++) {
            System.out.printf("(%s) %s ", i + 1, currentAnswers[i]);
        }
        System.out.println();
        System.out.println("Please type your answer: ");
        BigDecimal userAnswer = in.nextBigDecimal();

        if(userAnswer.equals(currentCorrectAnswer)) {
            return true;
        } else {
            return false;
        }
    }

    private void formatQuestionAndAnswers(String q){
        try {
            currentQuestion = "What " + q.substring(q.indexOf("is"));
            currentCorrectAnswer = new BigDecimal(q.substring(0, q.indexOf("is")).trim());
            currentAnswers[0] = currentCorrectAnswer;
            currentAnswers[1] = new BigDecimal(new Random().nextInt(100)).add(currentAnswers[0]);
            currentAnswers[2] = new BigDecimal(new Random().nextInt(100)).add(currentAnswers[0]).add(new BigDecimal(21));
        } catch (NumberFormatException e) {
            System.out.println("Problems formatting correct answer.");
        }
    }

    public BigDecimal getCorrectAnswer() {
        return currentCorrectAnswer;
    }
}

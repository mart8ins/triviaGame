package org.mart8ins;

import java.math.BigDecimal;
import java.util.*;

public class TriviaGame {
    private List<String> allQuestions = new ArrayList<>();
    private String currentQuestion;
    private List<BigDecimal> currentAnswers = new ArrayList<>(3);
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
        for(int i = 0; i < currentAnswers.size(); i++) {
            System.out.printf("(%s) %s ", i + 1, currentAnswers.get(i));
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
            currentAnswers.clear();
            currentQuestion = "What " + q.substring(q.indexOf("is"));
            currentCorrectAnswer = new BigDecimal(q.substring(0, q.indexOf("is")).trim());
            currentAnswers.add(currentCorrectAnswer);
            currentAnswers.add(new BigDecimal(new Random().nextInt(100)).add(currentCorrectAnswer));
            currentAnswers.add(new BigDecimal(new Random().nextInt(100)).add(currentCorrectAnswer).add(new BigDecimal(21)));

            Collections.shuffle(currentAnswers);
        } catch (NumberFormatException e) {
            System.out.println("Problems formatting correct answer.");
        }
    }

    public BigDecimal getCorrectAnswer() {
        return currentCorrectAnswer;
    }
}

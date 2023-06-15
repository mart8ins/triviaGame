package org.mart8ins;

import kong.unirest.Unirest;
import java.util.HashSet;
import java.util.Set;

public class FetchTriviaQuestions {
    static public Set<String> getTriviaQuestion(String gameType, int gameQuestionsLimit) throws FailedToFetchQuestions {
        Set<String> questions = new HashSet<>();
        String url = "http://numbersapi.com/random/" + gameType;

        while(questions.size() <= gameQuestionsLimit) {
            String response = Unirest.get(url).asString().getBody();
            questions.add(response);
            if(response == null) throw new FailedToFetchQuestions("Cant get questions from server.");
        }
        return questions;
    }
}

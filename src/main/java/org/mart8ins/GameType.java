package org.mart8ins;

import java.util.*;

public class GameType {
    static public String getTriviaType() {
        Scanner in = new Scanner(System.in);
        String userChoseGame;
        while(true) {
            userChoseGame = in.nextLine();
            if(userChoseGame.equals("1") || userChoseGame.equals("2") ||userChoseGame.equals("3") ||userChoseGame.equals("4")) {
                if(userChoseGame.equals("1")) {
                    userChoseGame = "trivia";
                }
                if(userChoseGame.equals("2")) {
                    userChoseGame = "year";
                }
                if(userChoseGame.equals("3")) {
                    userChoseGame = "date";
                }
                if(userChoseGame.equals("4")) {
                    userChoseGame = "math";
                }
                break;
            } else {
                System.out.println("Please enter correct game type.");
            }
        }
        return userChoseGame;
    }
}

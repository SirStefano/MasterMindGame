package org.example.gameScreen.helpers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class compare {
    public static userTry compareCodes(Color[] code, Color[] userGuess){
        int correct = 0;
        int correctPlace = 0;
        ArrayList<Color> secondCheck = new ArrayList<Color>();
        for(int i = 0; i<code.length; ++i){
            if(code[i]==userGuess[i]) {
                correctPlace++;
            }else{
                secondCheck.add(userGuess[i]);
            }
        }
        correct = correctPlace;
        for (Color guessNum : secondCheck) {
            for (Color codeNum : code) {
                if (guessNum == codeNum) {
                    correct++;
                    break;
                }
            }
        }
        return new userTry(correct, correctPlace);
    }
}

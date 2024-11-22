package org.example.gameScreen.helpers;

import java.awt.*;
import java.util.Random;

public class randomGenerator {
    public static Color[] generate(int length){
        Random random = new Random();
        int[] generatedNumbers = new int[length];
        for(int i = 0; i<length; ++i){
            int x;
            boolean next;
            do {
                next = false;
                x = random.nextInt(8);
                for(int ii = 0; ii<i; ++ii ){
                    if(generatedNumbers[ii]==x){
                        next = true;
                        break;
                    }
                }
            }while (next);
            generatedNumbers[i] = x;
        }
        return numbersToColors(generatedNumbers);
    }
    public static Color[] numbersToColors(int[] numbers){
        Color[] toReturn = new Color[numbers.length];
        for(int i = 0; i<numbers.length; ++i){
            switch (numbers[i]){
                case 0:
                    toReturn[i] = Color.BLUE;
                    break;
                case 1:
                    toReturn[i] = Color.CYAN;
                    break;
                case 2:
                    toReturn[i] = Color.GREEN;
                    break;
                case 3:
                    toReturn[i] = Color.MAGENTA;
                    break;
                case 4:
                    toReturn[i] = Color.ORANGE;
                    break;
                case 5:
                    toReturn[i] = Color.PINK;
                    break;
                case 6:
                    toReturn[i] = Color.RED;
                    break;
                case 7:
                    toReturn[i] = Color.YELLOW;
                    break;
            }
        }
        return toReturn;
    }
}

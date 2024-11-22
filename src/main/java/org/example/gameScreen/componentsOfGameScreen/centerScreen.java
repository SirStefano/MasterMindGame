package org.example.gameScreen.componentsOfGameScreen;

import org.example.gameScreen.buttons.roundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class centerScreen extends JPanel implements ActionListener {
    private final int rounds;
    private int currentRound;
    private final int toGuess;
    private roundButton[][] guessButtons;
    leftScreen colorsButton;
    public centerScreen(int _rounds, int _toGuess, leftScreen _colorsButton){
        super(new GridLayout(_rounds,_toGuess));
        rounds = _rounds;
        toGuess = _toGuess;
        currentRound = 0;
        colorsButton = _colorsButton;
        init();
    }
    private void init(){
        guessButtons = new roundButton[rounds][toGuess];
        for(int i = 0; i<rounds; ++i){
            for(int ii = 0; ii<toGuess; ++ii){
                guessButtons[i][ii] = new roundButton(false);
                guessButtons[i][ii].addActionListener(this);
                guessButtons[i][ii].setBackground(Color.white);
                add(guessButtons[i][ii]);
            }
        }
        for(int i = 0; i<toGuess; ++i){
            guessButtons[currentRound][i].setContentAreaFilled(true);
        }
    }
    public void nextRound(){
        for(int i = 0; i<toGuess; ++i){
            guessButtons[currentRound][i].setContentAreaFilled(false);
            guessButtons[currentRound+1][i].setContentAreaFilled(true);
        }
        currentRound++;
    }
    public Color[] getGuess(){
        Color[] toReturn = new Color[toGuess];
        for(int i = 0; i<toGuess; ++i){
            if(guessButtons[currentRound][i].getColor()==Color.BLACK){
                return null;
            }
            toReturn[i] = guessButtons[currentRound][i].getColor();
        }
        return toReturn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(currentRound != rounds) {
            roundButton button = (roundButton) e.getSource();
            for (int i = 0; i < toGuess; ++i) {
                if (guessButtons[currentRound][i] == button) {
                    Color color = colorsButton.getActiveColor();
                    if (color != null) {
                        for (int ii = 0; ii < toGuess; ++ii) {
                            if (guessButtons[currentRound][ii].getColor() == color) {
                                guessButtons[currentRound][ii].newCircleIcon(Color.black, false);
                                break;
                            }
                        }
                        button.newCircleIcon(color, true);
                    }
                }
            }
        }
    }
}

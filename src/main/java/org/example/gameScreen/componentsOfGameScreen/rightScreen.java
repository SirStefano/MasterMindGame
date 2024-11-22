package org.example.gameScreen.componentsOfGameScreen;

import org.example.gameScreen.helpers.userTry;

import javax.swing.*;
import java.awt.*;

public class rightScreen extends JPanel {
    private final int rounds;
    private int currentRound;
    private JLabel[] correct;
    private JLabel[] correctPlace;
    public rightScreen(int _rounds){
        super(new GridLayout(_rounds, 1, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        rounds = _rounds;
        currentRound = 0;
        init();
    }
    private void init(){
        correct = new JLabel[rounds];
        correctPlace = new JLabel[rounds];
        for(int i = 0; i<rounds; ++i){
            JPanel panel = new JPanel(new GridLayout(2,2,5,5));
            panel.add(new JLabel("Correct:"));
            correct[i] = new JLabel("",SwingConstants.CENTER);
            correct[i].setFont(new Font("Serif", Font.BOLD, 38-rounds*2));
            correct[i].setBorder(BorderFactory.createLineBorder(Color.black));
            panel.add(correct[i]);
            panel.add(new JLabel("Correct place:"));
            correctPlace[i] = new JLabel("",SwingConstants.CENTER);
            correctPlace[i].setFont(new Font("Serif", Font.BOLD, 38-rounds*2));
            correctPlace[i].setBorder(BorderFactory.createLineBorder(Color.black));
            panel.add(correctPlace[i]);
            add(panel);
        }
    }
    public void nextRound(userTry info){
        correct[currentRound].setText(String.valueOf(info.correct));
        correctPlace[currentRound].setText(String.valueOf(info.correctPlace));
        if(currentRound<rounds){
            currentRound++;
        }
    }
}

package org.example.gameScreen;

import org.example.MainWindow;
import org.example.gameScreen.componentsOfGameScreen.centerScreen;
import org.example.gameScreen.componentsOfGameScreen.downScreen;
import org.example.gameScreen.componentsOfGameScreen.leftScreen;
import org.example.gameScreen.componentsOfGameScreen.rightScreen;
import org.example.gameScreen.helpers.compare;
import org.example.gameScreen.helpers.randomGenerator;
import org.example.gameScreen.helpers.userTry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class game extends JPanel implements ActionListener {
    private final MainWindow precursor;
    private final Color[] code;
    private final int rounds;
    private int currentRound;
    private centerScreen center;
    private leftScreen left;
    private rightScreen right;
    private downScreen down;
    private JPanel up;
    private JLabel roundInformation;
    private JButton checkButton;
    private JButton returnToMainMenu;
    public game(MainWindow main ,int _codeLength, int _rounds){
        super(new BorderLayout());
        precursor = main;
        code = randomGenerator.generate(_codeLength);
        rounds = _rounds;
        currentRound = 0;
        init();
    }
    private void init(){
        left = new leftScreen();
        add(left, BorderLayout.LINE_START);
        center = new centerScreen(rounds,code.length, left);
        add(center, BorderLayout.CENTER);
        right = new rightScreen(rounds);
        add(right, BorderLayout.LINE_END);
        down = new downScreen(code.length);
        add(down, BorderLayout.PAGE_END);
        initUp();
        add(up, BorderLayout.PAGE_START);
    }
    private void initUp(){
        up = new JPanel(new FlowLayout());
        returnToMainMenu = new JButton("Main Menu");
        returnToMainMenu.addActionListener(this);
        up.add(returnToMainMenu);
        roundInformation = new JLabel("  Active Round: "+(currentRound+1)+"/"+rounds+"  ");
        roundInformation.setFont(new Font("Serif", Font.BOLD, 25));
        up.add(roundInformation);
        checkButton = new JButton("Check active round");
        checkButton.addActionListener(this);
        up.add(checkButton);
    }
    private void nextRound(userTry score){
        currentRound++;
        center.nextRound();
        right.nextRound(score);
        roundInformation.setText("Active Round: "+(currentRound+1)+"/"+rounds+"  ");
    }
    private void win(){
        down.revealCode(code);
        optionPane(true);
    }
    private void lose(){
        down.revealCode(code);
        optionPane(false);
    }
    private void optionPane(boolean isWon){
        String version;
        if(isWon){
            version = "WON";
        }else{
            version = "LOST";
        }
        String[] options = {"Play Again", "Exit"};
        int selection = JOptionPane.showOptionDialog(this, "YOU "+version+", what next?",
                "YOU "+version, 0,3, null,options, options[0]);
        if(selection == 0){
            precursor.initMenu();
        } else if (selection == 1) {
            System.exit(0);
        }
    }
    private void checkFun(){
        Color[] guessCode = center.getGuess();
        if(guessCode != null){
            userTry score = compare.compareCodes(code, guessCode);
            if(score.correctPlace == code.length){
                right.nextRound(score);
                win();
            }else if(currentRound >= rounds-1){
                right.nextRound(score);
                lose();
            }else{
                nextRound(score);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == checkButton){
            checkFun();
        }else if(button == returnToMainMenu){
            precursor.initMenu();
        }
    }
}

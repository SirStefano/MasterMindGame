package org.example.mainMenu;

import org.example.MainWindow;
import org.example.gameScreen.buttons.roundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JPanel implements ActionListener {
    private final MainWindow precursor;
    private final JButton gameRules = new JButton("Game Rules");
    private final JButton startGame = new JButton("Start Game");
    private final labelChooser pickLength = new labelChooser
            ("Length of secret code:", 4, 3, 7);
    private final labelChooser pickRounds = new labelChooser
            ("Limit of rounds to guess code:",8, 3, 10);
    public menu(MainWindow main){
        precursor = main;
        init();
    }
    private void init(){
        JLabel text = new JLabel("Welcome in Master Mind!", SwingConstants.CENTER);
        text.setFont(new Font("Serif", Font.ITALIC, 40));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(text);
        gameRules.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameRules.setFont(new Font("Serif", Font.PLAIN, 20));
        gameRules.addActionListener(this);
        add(gameRules);
        JLabel configText = new JLabel("Configuration of your game:", SwingConstants.CENTER);
        configText.setFont(new Font("Serif", Font.PLAIN, 25));
        configText.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(configText);
        add(pickLength);
        add(pickRounds);
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.setFont(new Font("Serif", Font.PLAIN, 20));
        startGame.addActionListener(this);
        add(startGame);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    private void runGame(){
        precursor.initGame(pickLength.getValue(), pickRounds.getValue());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == startGame){
            runGame();
        }else if(button == gameRules){
            String message = "1. Master Mind is a game where the point of your game is to guess a code\n" +
                    "2. The code is represented by colored circles\n" +
                    "3. Every color in code is different. So you can't fill in same color twice\n" +
                    "       Correct code example: Green, Blue, Yellow\n" +
                    "       Incorrect code example: Green, Green, Yellow\n" +
                    "4. You have limited rounds to guess code\n" +
                    "5. After every round you will receive the following information: \n" +
                    "       How many colors you guessed correctly\n" +
                    "       How many guessed colors are also in the correct order\n" +
                    "       Example: \n" +
                    "           Code: Green, Yellow, Pink \n" +
                    "           Your guess: Green, Pink, Yellow\n" +
                    "           Correct: 3\n" +
                    "           Correct order: 1\n\n" +
                    "After every round analyze the information about correct colors and their order\n" +
                    "Hope you win, Good luck.";
            JOptionPane.showMessageDialog(this, message,
                    "Game Rules", JOptionPane.INFORMATION_MESSAGE, null);
        }
    }
}

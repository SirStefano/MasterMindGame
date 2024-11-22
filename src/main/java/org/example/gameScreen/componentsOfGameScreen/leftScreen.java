package org.example.gameScreen.componentsOfGameScreen;

import org.example.gameScreen.buttons.roundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.BatchUpdateException;

public class leftScreen extends JPanel implements ActionListener {
    private Color activeColor;
    private roundButton[] pickColor = new roundButton[8];
    private JButton howToPlay;
    public leftScreen(){
        super(new FlowLayout());
        //setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        setPreferredSize(new Dimension(100,400));
        activeColor = null;
        init();
    }
    private void init() {
        howToPlay = new JButton("How to play");
        howToPlay.addActionListener(this);
        add(howToPlay);
        pickColor[0] = new roundButton(true, Color.BLUE);
        pickColor[1] = new roundButton(true, Color.CYAN);
        pickColor[2] = new roundButton(true, Color.GREEN);
        pickColor[3] = new roundButton(true, Color.MAGENTA);
        pickColor[4] = new roundButton(true, Color.ORANGE);
        pickColor[5] = new roundButton(true, Color.PINK);
        pickColor[6] = new roundButton(true, Color.RED);
        pickColor[7] = new roundButton(true, Color.YELLOW);
        for(roundButton x:pickColor){
            x.setBackground(Color.GRAY);
            x.addActionListener(this);
            add(x);
        }
    }
    public Color getActiveColor(){
        return activeColor;
    }

    private void howToPLayScreen(){
        String message = "1. Pick a color by pressing one of the colorful circles from the vertical bar\n" +
                "    on the left side, located under the How to Play button\n" +
                "2. Press one of the empty circles on the white background\n" +
                "3. Repeat step 1 and 2 for all empty circles on the white background\n" +
                "4. Press Check active round button\n" +
                "5. Congratulations! You just played your first round in Master Mind. \n" +
                "For more information about the game, click Game Rules in the Main Menu";
        JOptionPane.showMessageDialog(this, message,
                "How to Play", JOptionPane.INFORMATION_MESSAGE, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == howToPlay){
            howToPLayScreen();
        }else {
            roundButton rButton = (roundButton) button;
            rButton.setContentAreaFilled(true);
            activeColor = rButton.getColor();
            for (roundButton x : pickColor) {
                if (x != rButton) {
                    x.setContentAreaFilled(false);
                }
            }
        }
    }
}

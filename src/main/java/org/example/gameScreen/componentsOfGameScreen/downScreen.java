package org.example.gameScreen.componentsOfGameScreen;

import org.example.gameScreen.buttons.roundButton;

import javax.swing.*;
import java.awt.*;

public class downScreen extends JPanel {
    private roundButton[] code;
    public downScreen(int codeLength){
        super(new FlowLayout());
        code = new roundButton[codeLength];
        init();
    }
    private void init(){
        add(new JLabel("Secret code: "));
        for(int i = 0; i<code.length; ++i){
            code[i] = new roundButton(true, Color.black);
            add(code[i]);
        }
    }
    public void revealCode(Color[] colorsCode){
        for(int i = 0; i<code.length; ++i){
            code[i].newCircleIcon(colorsCode[i], true);
        }
    }
}

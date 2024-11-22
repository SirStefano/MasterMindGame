package org.example.mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class labelChooser extends JPanel {
    private final JSpinner chooser;
    public labelChooser(final String text, final int value, final int minimum, final int maximum){
        super(new FlowLayout());
        setMaximumSize(new Dimension(300, 30));
        JLabel label = new JLabel(text);
        label.setFont(new Font("Serif", Font.PLAIN, 15));
        add(label);
        chooser = new JSpinner(new SpinnerNumberModel(value, minimum, maximum, 1));
        add(chooser);
    }
    public int getValue(){
        return (Integer) chooser.getValue();
    }
}

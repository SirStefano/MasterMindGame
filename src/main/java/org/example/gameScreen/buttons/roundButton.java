package org.example.gameScreen.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class roundButton extends JButton {
    private boolean filled;
    private Color color;
    public roundButton(boolean fill){
        init(Color.BLACK, fill);
    }
    public roundButton(boolean fill, Color _color){
        init(_color, fill);
    }
    private void init(Color _color, boolean fill){
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        newCircleIcon(_color, fill);
    }
    public void newCircleIcon(Color _color, boolean fill){
        filled = fill;
        color = _color;
        BufferedImage img = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 40, 40);
        if(filled){
            g2d.setColor(color);
            g2d.fill(circle);
        }
        g2d.draw(circle);
        g2d.dispose();
        setIcon(new ImageIcon(img));
    }
    public Color getColor(){
        return color;
    }
}

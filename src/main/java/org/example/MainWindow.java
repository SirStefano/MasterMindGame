package org.example;

import javax.swing.*;

import org.example.gameScreen.game;
import org.example.mainMenu.menu;


public class MainWindow extends JFrame {
    game gamePanel;
    menu menuPanel;
    public static void main(String[] args) {
        MainWindow window = new MainWindow("MasterMind");
        window.init();
        window.setVisible(true);
    }
    private MainWindow(String title){super(title);}
    private void init(){
        setSize(600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMenu();
    }
    public void initMenu(){
        clear();
        menuPanel = new menu(this);
        add(menuPanel);
    }
    public void initGame(int codeLength, int rounds){
        clear();
        gamePanel = new game(this ,codeLength, rounds);
        add(gamePanel);
    }
    private void clear(){
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}
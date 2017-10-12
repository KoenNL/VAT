package Presentation;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(String title) {
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPanel(JPanel panel) {
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

}

package Presentation;

import javax.swing.*;

abstract public class Frame extends JFrame {

    public Frame(String title) {
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPanel(Panel panel) {
        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);
    }

}

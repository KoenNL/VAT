package Presentation;

import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShapeFrame extends Frame {

    private JPanel layoutPanel;

    public ShapeFrame(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.layoutPanel = new JPanel();
        this.layoutPanel.setLayout(new GridLayout(2, 1));

        this.add(layoutPanel);
    }

    @Override
    public void addPanel(Panel shapePanel) {
        this.layoutPanel.add(shapePanel);
        this.pack();
        this.setVisible(true);
    }
}

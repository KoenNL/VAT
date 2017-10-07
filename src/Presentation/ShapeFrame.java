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
        this.layoutPanel.setLayout(new GridBagLayout());

        this.add(layoutPanel);
    }

    public void setShapePanel(ShapePanel shapePanel) {
        this.layoutPanel.add(shapePanel, this.getGridbagConstraints(0));
    }

    public void setShapeButtonPanel(ShapeButtonPanel shapeButtonPanel) {
        this.layoutPanel.add(shapeButtonPanel, this.getGridbagConstraints(1));
        this.pack();
        this.setVisible(true);
    }

    private GridBagConstraints getGridbagConstraints(int position) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = position;
        gridBagConstraints.weightx = 1;

        return gridBagConstraints;
    }

    @Override
    public void addPanel(Panel shapePanel) {
        this.layoutPanel.add(shapePanel);
        this.pack();
        this.setVisible(true);
    }
}

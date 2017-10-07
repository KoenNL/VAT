package Presentation;

import javax.swing.*;
import java.awt.*;

public class ShapeButtonPanel extends Panel {

    private ShapeButtonHandler shapeButtonHandler;
    private ShapePanel shapePanel;
    private JButton saveButton, cancelButton;

    public ShapeButtonPanel(ShapePanel shapePanel) {
        super();

        this.setBackground(Color.BLUE);

        this.shapePanel = shapePanel;

        this.shapeButtonHandler = new ShapeButtonHandler(this.shapePanel);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        Insets insets = new Insets(0, 10, 0, 0);

        // Create cancel button
        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setActionCommand("cancel");
        this.cancelButton.addActionListener(this.shapeButtonHandler);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = insets;
        gridBagConstraints.weightx = 1;
        this.add(this.cancelButton);

        // Create save button
        this.saveButton = new JButton("Save");
        this.saveButton.setActionCommand("saveShape");
        this.saveButton.addActionListener(this.shapeButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = insets;
        gridBagConstraints.weightx = 1;
        this.add(this.saveButton);
    }
}
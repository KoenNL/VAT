package Presentation;

import javax.swing.*;
import java.awt.*;

public class ShapeButtonPanel extends Panel {

    private ShapeButtonHandler shapeButtonHandler;
    private ShapePanel shapePanel;
    private OverviewPanel overviewPanel;
    private JButton saveButton, cancelButton;

    public ShapeButtonPanel(ShapePanel shapePanel, OverviewPanel overviewPanel, String type) throws PresentationException {
        super();

        this.shapePanel = shapePanel;
        this.overviewPanel = overviewPanel;

        this.shapeButtonHandler = new ShapeButtonHandler(this.shapePanel, this.overviewPanel);

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
        switch (type) {
            case "add":
                this.saveButton = new JButton("Add");
                this.saveButton.setActionCommand("addShape");
                break;
            case "edit":
                this.saveButton = new JButton("Edit");
                this.saveButton.setActionCommand("editShape");
                break;
            default:
                throw new PresentationException("Invalid shape button type '" + type + "' provided.");
        }

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
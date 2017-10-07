package Presentation;

import Domain.RectangularPrism;
import Domain.Shape;

import javax.swing.*;
import java.awt.*;

public class RectangularPrismPanel extends ShapePanel {

    private JLabel lengthLabel, widthLabel, heightLabel;
    private JTextField lengthField, widthField, heightField;

    public RectangularPrismPanel(Shape shape) {
        super(shape);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        // Create length label
        this.lengthLabel = new JLabel("Length");
        this.lengthLabel.setHorizontalAlignment(JLabel.LEFT);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.lengthLabel, gridBagConstraints);

        // Create length field
        this.lengthField = new JTextField(6);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.lengthField, gridBagConstraints);

        // Create width label
        this.widthLabel = new JLabel("Width");
        this.widthLabel.setHorizontalAlignment(JLabel.LEFT);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.widthLabel, gridBagConstraints);

        // Create width field
        this.widthField = new JTextField(6);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.widthField, gridBagConstraints);
        
        // Create height label
        this.heightLabel = new JLabel("Height");
        this.heightLabel.setHorizontalAlignment(JLabel.LEFT);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.heightLabel, gridBagConstraints);

        // Create height field
        this.heightField = new JTextField(6);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.heightField, gridBagConstraints);
    }

    @Override
    public Shape toShape() {
        if (this.shape == null) {
            this.shape = new RectangularPrism(
                    Double.parseDouble(this.lengthField.getText()),
                    Double.parseDouble(this.widthField.getText()),
                    Double.parseDouble(this.heightField.getText())
            );
        } else {
            this.shape.setLength(Double.parseDouble(this.lengthField.getText()));
            this.shape.setWidth(Double.parseDouble(this.widthField.getText()));
            this.shape.setHeight(Double.parseDouble(this.heightField.getText()));
        }

        return this.shape;
    }
}

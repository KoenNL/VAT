package Presentation;

import Domain.Shape;
import Domain.SquarePyramid;

import javax.swing.*;
import java.awt.*;

public class SquarePyramidPanel extends ShapePanel {

    private JLabel lengthLabel, heightLabel;
    private JTextField lengthField, heightField;

    public SquarePyramidPanel(Shape shape) {
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
        this.lengthField.setText(String.format("%.2f", shape.getLength()));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.lengthField, gridBagConstraints);

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
        this.heightField.setText(String.format("%.2f", shape.getHeight()));
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
            this.shape = new SquarePyramid(
                    Double.parseDouble(this.lengthField.getText().replace(',', '.')),
                    Double.parseDouble(this.heightField.getText().replace(',', '.'))
            );
        } else {
            this.shape.setLength(Double.parseDouble(this.lengthField.getText().replace(',', '.')));
            this.shape.setHeight(Double.parseDouble(this.heightField.getText().replace(',', '.')));
        }

        return this.shape;
    }

    public boolean validateForm() {
        this.shape = this.toShape();

        boolean valid = true;
        if (this.shape.getLength() == 0.00) {
            this.lengthLabel.setForeground(Color.RED);
            valid = false;
        } else {
            this.lengthLabel.setForeground(Color.BLACK);
        }

        if (this.shape.getHeight() == 0.00) {
            this.heightLabel.setForeground(Color.RED);
            valid = false;
        } else {
            this.heightLabel.setForeground(Color.BLACK);
        }

        return valid;
    }
}

package Presentation;

import Domain.Cone;
import Domain.Shape;

import javax.swing.*;
import java.awt.*;

public class ConePanel extends ShapePanel {

    private JLabel radiusLabel, heightLabel;
    private JTextField radiusField, heightField;

    public ConePanel(Shape shape) {
        super(shape);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        // Create radius label
        this.radiusLabel = new JLabel("Radius");
        this.radiusLabel.setHorizontalAlignment(JLabel.LEFT);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.radiusLabel, gridBagConstraints);

        // Create radius field
        this.radiusField = new JTextField(6);
        this.radiusField.setText(String.format("%.2f", shape.getRadius()));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.radiusField, gridBagConstraints);

        // Create height label
        this.heightLabel = new JLabel("Height");
        this.heightLabel.setHorizontalAlignment(JLabel.LEFT);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.heightLabel, gridBagConstraints);

        // Create height field
        this.heightField = new JTextField(6);
        this.heightField.setText(String.format("%.2f", shape.getHeight()));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.heightField, gridBagConstraints);
    }

    @Override
    public Shape toShape() {
        if (this.shape == null) {
            this.shape = new Cone(
                    Double.parseDouble(this.radiusField.getText().replace(',', '.')),
                    Double.parseDouble(this.heightField.getText().replace(',', '.'))
            );
        } else {
            this.shape.setRadius(Double.parseDouble(this.radiusField.getText().replace(',', '.')));
            this.shape.setHeight(Double.parseDouble(this.heightField.getText().replace(',', '.')));
        }

        return this.shape;
    }

    public boolean validateForm() {
        this.shape = this.toShape();

        boolean valid = true;
        if (this.shape.getRadius() == 0.00) {
            this.radiusLabel.setForeground(Color.RED);
            valid = false;
        } else {
            this.radiusLabel.setForeground(Color.BLACK);
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

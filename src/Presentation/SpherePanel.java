package Presentation;

import Domain.Shape;
import Domain.Sphere;

import javax.swing.*;
import java.awt.*;

public class SpherePanel extends ShapePanel {

    private JLabel radiusLabel;
    private JTextField radiusField;

    public SpherePanel(Shape shape) {
        super(shape);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        Insets insets = new Insets(0, 20, 0, 0);

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
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);;
        gridBagConstraints.weightx = 1;
        this.add(this.radiusField, gridBagConstraints);
    }

    @Override
    public Shape toShape() {
        if (this.shape == null) {
            this.shape = new Sphere(Double.parseDouble(this.radiusField.getText()));
        }

        return this.shape;
    }
}

package Presentation;

import Domain.Shape;
import Domain.Sphere;

import javax.swing.*;

public class SpherePanel extends ShapePanel {

    private JTextField radiusField;

    public SpherePanel(int rows, int columns, Shape shape, OverviewPanel overviewPanel) {
        super(rows, columns, shape, overviewPanel);
    }

    @Override
    public Shape toShape() {
        if (this.shape == null) {
            this.shape = new Sphere(Double.parseDouble(this.radiusField.getText()));
        }

        return this.shape;
    }
}

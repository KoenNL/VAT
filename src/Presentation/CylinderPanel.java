package Presentation;

import Domain.Cylinder;
import Domain.Shape;

import javax.swing.*;

public class CylinderPanel extends ShapePanel {

    private JTextField radiusField, heightField;

    public CylinderPanel(Shape shape, OverviewPanel overviewPanel) {
        super(shape, overviewPanel);
    }

    @Override
    public Shape toShape() {
        if (this.shape == null) {
            this.shape = new Cylinder(
                    Double.parseDouble(this.radiusField.getText()),
                    Double.parseDouble(this.heightField.getText())
            );
        } else {
            this.shape.setRadius(Double.parseDouble(this.radiusField.getText()));
            this.shape.setHeight(Double.parseDouble(this.heightField.getText()));
        }

        return this.shape;
    }
}

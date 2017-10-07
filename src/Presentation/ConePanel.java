package Presentation;

import Domain.Cone;
import Domain.Shape;

import javax.swing.*;

public class ConePanel extends ShapePanel {

    private JTextField radiusField, heightField;

    public ConePanel(int rows, int columns, Shape shape, OverviewPanel overviewPanel) {
        super(rows, columns, shape, overviewPanel);
    }

    @Override
    public Shape toShape() {
        if (this.shape == null) {
            this.shape = new Cone(
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

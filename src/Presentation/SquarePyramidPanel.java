package Presentation;

import Domain.Shape;
import Domain.SquarePyramid;

import javax.swing.*;

public class SquarePyramidPanel extends ShapePanel {

    private JTextField lengthField, widthField, heightField;

    public SquarePyramidPanel(int rows, int columns, Shape shape, OverviewPanel overviewPanel) {
        super(rows, columns, shape, overviewPanel);
    }

    @Override
    public Shape toShape() {
        if (this.shape == null) {
            this.shape = new SquarePyramid(
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

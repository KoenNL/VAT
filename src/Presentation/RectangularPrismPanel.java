package Presentation;

import Domain.RectangularPrism;
import Domain.Shape;

import javax.swing.*;

public class RectangularPrismPanel extends ShapePanel {

    private JTextField lengthField, widthField, heightField;

    public RectangularPrismPanel(Shape shape, OverviewPanel overviewPanel) {
        super(shape, overviewPanel);
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

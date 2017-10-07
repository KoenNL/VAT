package Presentation;

import Domain.Shape;

import javax.swing.*;
import java.awt.*;

abstract public class ShapePanel extends Panel {

    protected Shape shape;

    public ShapePanel(Shape shape) {
        super();

        this.shape = shape;
        this.setLayout(new GridBagLayout());
    }

    /**
     * Close the frame arround this panel.
     */
    public void close() {
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    /**
     * Validate if the form values are correct and the labels of incorrect values.
     *
     * @return boolean
     */
    abstract public boolean validateForm();

    /**
     * Change the values of the panel into it's corresponding shape object.
     *
     * @return Shape
     */
    abstract public Shape toShape();

}

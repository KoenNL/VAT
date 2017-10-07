package Presentation;

import Domain.Shape;

import javax.swing.*;
import java.awt.*;

abstract public class ShapePanel extends Panel {

    protected Shape shape;

    public ShapePanel(Shape shape) {
        super();

        this.setLayout(new GridBagLayout());
    }

    abstract public Shape toShape();

}

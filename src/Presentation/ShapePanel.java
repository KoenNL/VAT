package Presentation;

import Domain.Shape;

import javax.swing.*;

abstract public class ShapePanel extends Panel {

    protected Shape shape;
    protected JButton saveButton, cancelButton;

    public ShapePanel(Shape shape, OverviewPanel overviewPanel) {
        super();
    }

    abstract public Shape toShape();

}

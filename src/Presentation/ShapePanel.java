package Presentation;

import Domain.Shape;

import javax.swing.*;

abstract public class ShapePanel extends Panel {

    protected Shape shape;
    protected JButton saveButton, cancelButton;

    public ShapePanel(int rows, int columns, Shape shape, OverviewPanel overviewPanel) {
        super(rows, columns);
    }

    abstract public Shape toShape();

}

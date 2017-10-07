package Presentation;

import Domain.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeButtonHandler implements ActionListener {

    private ShapePanel shapePanel;
    private OverviewPanel overviewPanel;

    public ShapeButtonHandler(ShapePanel shapePanel, OverviewPanel overviewPanel) {
        this.shapePanel = shapePanel;
        this.overviewPanel = overviewPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "addShape":
                this.addShape(true);
                break;
            case "editShape":
                this.addShape(false);
                break;
            case "cancel":
                this.cancel();
                break;
        }
    }

    /**
     * Save the shape to the shape manager, update the list in the overview panel and close the shape frame.
     */
    private void addShape(boolean addNew) {
        if (this.shapePanel.validateForm()) {
            Shape shape = this.shapePanel.toShape();
            if (addNew) {
                this.overviewPanel.getShapeManager().addShape(shape);
                this.overviewPanel.setInfo("Shape " + shape + " has been added", OverviewPanel.INFO_SUCCESS);
            } else {
                this.overviewPanel.setInfo("Shape " + shape + " has been updated", OverviewPanel.INFO_SUCCESS);
            }
            this.overviewPanel.refreshShapeList();
            this.shapePanel.close();
        }
    }

    /**
     * Close the shape frame without saving.
     */
    private void cancel() {
        this.shapePanel.close();
    }
}

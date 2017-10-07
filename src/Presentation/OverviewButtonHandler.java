package Presentation;

import Domain.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverviewButtonHandler implements ActionListener {

    private OverviewPanel overviewPanel;

    public OverviewButtonHandler(OverviewPanel overviewPanel) {
        this.overviewPanel = overviewPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "save":

                break;
            case "load":

                break;
            case "newShape":

                break;
            case "editShape":

                break;
            case "deleteShape":
                this.deleteShape();
                break;
            case "calculateTotalVolume":
                this.calculateTotalVolume();
                break;
        }
    }

    private void save() {

    }

    private void load() {

    }

    private void newShape(String type) {

    }

    private void editShape() {

    }

    /**
     * Delete a shape.
     */
    private void deleteShape() {
        if (this.overviewPanel.getSelectedShape() == null) {
            this.overviewPanel.setInfo("No shape selected", OverviewPanel.INFO_INFO);
            return;
        }

        Shape shape = this.overviewPanel.getSelectedShape();
        if (this.overviewPanel.getShapeManager().deleteShape(shape)) {
            this.overviewPanel.refreshShapeList();
            this.overviewPanel.setInfo("Shape " + shape + " has been deleted.", OverviewPanel.INFO_SUCCESS);
        } else {
            this.overviewPanel.setInfo("Shape " + shape + " has NOT been deleted.", OverviewPanel.INFO_WARNING);
        }
    }

    /**
     * Calculate the total volume of all loaded shapes.
     */
    private void calculateTotalVolume() {
        double totalVolume = this.overviewPanel.getShapeManager().calculateTotalVolume();
        this.overviewPanel.setInfo("The total volume is: " + String.format("%.2f", totalVolume), OverviewPanel.INFO_INFO);
    }
}

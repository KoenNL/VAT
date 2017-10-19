package Presentation;

import BusinessLogic.ExceptionHandler;
import BusinessLogic.BusinessLogicException;
import BusinessLogic.ShapeFrameFactory;
import DataStorage.DAOException;
import DataStorage.FileShapeDAO;
import DataStorage.MySQLShapeDAO;
import Domain.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverviewButtonHandler implements ActionListener {

    private OverviewPanel overviewPanel;
    private JFileChooser fileChooser;

    public OverviewButtonHandler(OverviewPanel overviewPanel) {
        this.overviewPanel = overviewPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "saveShapes":
                this.saveShapes();
                break;
            case "loadShapes":
                this.loadShapes();
                break;
            case "newShape":
                this.newShape();
                break;
            case "editShape":
                this.editShape();
                break;
            case "deleteShape":
                this.deleteShape();
                break;
            case "calculateTotalVolume":
                this.calculateTotalVolume();
                break;
            case "importShapes":
                this.importShapes();
                break;
            case "exportShapes":
                this.exportShapes();
                break;
        }
    }

    /**
     * Save all currently loaded shapes.
     */
    private void saveShapes() {
        try {
            this.overviewPanel.getShapeManager().setDAO(new MySQLShapeDAO());

            if (this.overviewPanel.getShapeManager().save()) {
                this.overviewPanel.setInfo("Shapes saved", OverviewPanel.INFO_SUCCESS);
            } else {
                this.overviewPanel.setInfo("Shapes not saved", OverviewPanel.INFO_WARNING);
            }
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo("Unable to save shapes", OverviewPanel.INFO_DANGER);
        }
    }

    /**
     * Load a list of shapes.
     */
    private void loadShapes() {
        try {
            if (this.overviewPanel.getShapeManager().getDAOType() == null) {
                this.overviewPanel.getShapeManager().setDAO(new MySQLShapeDAO());
            }
            if (this.overviewPanel.getShapeManager().load()) {
                this.overviewPanel.setInfo("Shapes loaded", OverviewPanel.INFO_SUCCESS);
                this.overviewPanel.refreshShapeList();
            } else {
                this.overviewPanel.setInfo("No shapes loaded", OverviewPanel.INFO_INFO);
            }
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo(exception.getFriendlyMessage(), OverviewPanel.INFO_DANGER);
        }
    }

    /**
     * Create a new shape.
     */
    private void newShape() {
        if (this.overviewPanel.getNewShapeSelectorValue() == null) {
            this.overviewPanel.setInfo("No shape type selected", OverviewPanel.INFO_INFO);
            return;
        }

        String shapeType = this.overviewPanel.getNewShapeSelectorValue();
        try {
            ShapeFrameFactory.createShapeFrame(shapeType, this.overviewPanel);
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo(exception.getFriendlyMessage(), OverviewPanel.INFO_WARNING);
        }
    }

    /**
     * Edit an existing shape.
     */
    private void editShape() {
        if (this.overviewPanel.getSelectedShape() == null) {
            this.overviewPanel.setInfo("No shape selected", OverviewPanel.INFO_INFO);
            return;
        }

        try {
            ShapeFrameFactory.createShapeFrame(this.overviewPanel.getSelectedShape(), this.overviewPanel);
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo(exception.getFriendlyMessage(), OverviewPanel.INFO_WARNING);
        }
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
        if (this.overviewPanel.getShapeManager().getShapes().size() > 0) {
            double totalVolume = this.overviewPanel.getShapeManager().calculateTotalVolume();
            this.overviewPanel.setInfo("The total volume is: " + String.format("%.2f", totalVolume), OverviewPanel.INFO_INFO);
        } else {
            this.overviewPanel.setInfo("There are no shapes", OverviewPanel.INFO_INFO);
        }
    }

    /**
     * Prepare the file chooser.
     */
    private void prepareFileChooser() {
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    /**
     * Import shapes from a file.
     */
    private void importShapes() {
        this.prepareFileChooser();

        int returnValue = this.fileChooser.showOpenDialog(this.overviewPanel);
        if (returnValue != JFileChooser.APPROVE_OPTION) {
            this.overviewPanel.setInfo("No file selected");
            return;
        }
        try {
            this.overviewPanel.getShapeManager().setDAO(new FileShapeDAO(this.fileChooser.getSelectedFile()));
            if (this.overviewPanel.getShapeManager().load()) {
                this.overviewPanel.setInfo("Shapes loaded", OverviewPanel.INFO_SUCCESS);
                this.overviewPanel.refreshShapeList();
            } else {
                this.overviewPanel.setInfo(
                        "Could not load shapes from " + this.fileChooser.getSelectedFile().getName(),
                        OverviewPanel.INFO_WARNING
                );
            }
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo(exception.getFriendlyMessage(), OverviewPanel.INFO_WARNING);
        }
    }

    /**
     * Export shapes to a file.
     */
    private void exportShapes() {
        this.prepareFileChooser();

        int returnValue = this.fileChooser.showOpenDialog(this.overviewPanel);
        if (returnValue != JFileChooser.APPROVE_OPTION) {
            this.overviewPanel.setInfo("No file selected");
            return;
        }
        if (this.overviewPanel.getShapeManager().getShapes().size() == 0) {
            this.overviewPanel.setInfo("There are no shapes", OverviewPanel.INFO_INFO);
            return;
        }
        try {
            this.overviewPanel.getShapeManager().setDAO(new FileShapeDAO(this.fileChooser.getSelectedFile()));
            if (this.overviewPanel.getShapeManager().save()) {
                this.overviewPanel.setInfo(
                        "Exported shapes to " + this.fileChooser.getSelectedFile().getName(),
                        OverviewPanel.INFO_SUCCESS
                );
            } else {
                this.overviewPanel.setInfo(
                        "Could not export shapes to " + this.fileChooser.getSelectedFile().getName(),
                        OverviewPanel.INFO_WARNING
                );
            }
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo(exception.getFriendlyMessage(), OverviewPanel.INFO_WARNING);
        }
    }
}

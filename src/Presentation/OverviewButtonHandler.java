package Presentation;

import BusinessLogic.ExceptionHandler;
import BusinessLogic.BusinessLogicException;
import BusinessLogic.ShapeFrameFactory;
import DataStorage.DAOException;
import DataStorage.MySQLDAO;
import Domain.Shape;
import Main.Config;

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

                break;
            case "deleteShape":
                this.deleteShape();
                break;
            case "calculateTotalVolume":
                this.calculateTotalVolume();
                break;
        }
    }

    private void saveShapes() {
        try {
            if (this.overviewPanel.getShapeManager().getDAOType() == null) {
                this.overviewPanel.getShapeManager().setDAO(new MySQLDAO(new Config()));
                if (this.overviewPanel.getShapeManager().save()) {
                    this.overviewPanel.setInfo("Shapes saved", OverviewPanel.INFO_SUCCESS);
                } else {
                    this.overviewPanel.setInfo("Shapes not saved", OverviewPanel.INFO_WARNING);
                }
            }
        } catch (DAOException exception) {
            ExceptionHandler.handleException(exception.getException(), exception.getFriendlyMessage());
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo("Unable to save shapes", OverviewPanel.INFO_DANGER);
        }
    }

    private void loadShapes() {
        try {
            if (this.overviewPanel.getShapeManager().getDAOType() == null) {
                this.overviewPanel.getShapeManager().setDAO(new MySQLDAO(new Config()));
            }
            if (this.overviewPanel.getShapeManager().load()) {
                this.overviewPanel.setInfo("Shapes loaded", OverviewPanel.INFO_SUCCESS);
                this.overviewPanel.refreshShapeList();
            } else {
                this.overviewPanel.setInfo("No shapes loaded", OverviewPanel.INFO_INFO);
            }
        } catch (DAOException exception) {
            ExceptionHandler.handleException(exception.getException(), exception.getFriendlyMessage());
        } catch (BusinessLogicException exception) {
            this.overviewPanel.setInfo(exception.getFriendlyMessage(), OverviewPanel.INFO_DANGER);
        }
    }

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

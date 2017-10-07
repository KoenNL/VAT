package Main;

import BusinessLogic.ExceptionHandler;
import BusinessLogic.ShapeManager;
import Presentation.OverviewFrame;
import Presentation.OverviewPanel;

public class Main {

    public static void main(String args[]) {
        // Set debugging true for development, false for production.
        ExceptionHandler.setDebug(true);

        OverviewFrame overviewFrame = new OverviewFrame("VAT");
        overviewFrame.addPanel(new OverviewPanel(new ShapeManager()));
    }

}

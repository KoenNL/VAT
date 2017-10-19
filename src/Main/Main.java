package Main;

import BusinessLogic.ExceptionHandler;
import BusinessLogic.ShapeManager;
import Presentation.Frame;
import Presentation.OverviewPanel;

public class Main {

    public static void main(String args[]) {
        Config config = new Config();
        // Set debugging true for development, false for production.
        ExceptionHandler.setDebug(config.isDebug());

        Frame overviewFrame = new Frame("VAT");
        overviewFrame.addPanel(new OverviewPanel(new ShapeManager(config)));
    }

}

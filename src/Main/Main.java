package Main;

import Presentation.OverviewFrame;
import Presentation.OverviewPanel;

public class Main {

    public static void main(String args[]) {
        OverviewFrame overviewFrame = new OverviewFrame("VAT");
        overviewFrame.addPanel(new OverviewPanel(2, 3));
    }

}
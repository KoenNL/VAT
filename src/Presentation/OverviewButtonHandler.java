package Presentation;

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

    private void calculateTotalVolume() {
        double totalVolume = this.overviewPanel.getShapeManager().calculateTotalVolume();
        this.overviewPanel.setInfo("The total volume is: " + String.format("%.2f", totalVolume), "info");
    }
}

package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeButtonHandler implements ActionListener {

    private ShapePanel shapePanel;

    public ShapeButtonHandler(ShapePanel shapePanel) {
        this.shapePanel = shapePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "saveShape":
                this.saveShape();
                break;
            case "cancel":
                this.cancel();
                break;
        }
    }

    private void saveShape() {

    }

    private void cancel() {

    }
}

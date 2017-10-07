package Presentation;

import javax.swing.*;
import java.awt.*;

public class ShapeFrame extends Frame {

    private JPanel layoutPanel;

    /**
     * @param title String
     */
    public ShapeFrame(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.layoutPanel = new JPanel();
        this.layoutPanel.setLayout(new GridBagLayout());

        this.add(layoutPanel);
    }

    /**
     * Set the shape panel.
     *
     * @param shapePanel ShapePanel
     */
    public void setShapePanel(ShapePanel shapePanel) {
        this.layoutPanel.add(shapePanel, this.getGridBagConstraints(0));
    }

    /**
     * Set the shape button panel and make the frame visible.
     *
     * @param shapeButtonPanel ShapeButtonPanel
     */
    public void setShapeButtonPanel(ShapeButtonPanel shapeButtonPanel) {
        this.layoutPanel.add(shapeButtonPanel, this.getGridBagConstraints(1));
        this.pack();
        this.setVisible(true);
    }

    /**
     * Get general gridBag constraints.
     *
     * @param position int
     * @return GridBagConstraints
     */
    private GridBagConstraints getGridBagConstraints(int position) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = position;
        gridBagConstraints.weightx = 1;

        return gridBagConstraints;
    }

    @Override
    public void addPanel(Panel shapePanel) {
        this.layoutPanel.add(shapePanel);
        this.pack();
        this.setVisible(true);
    }
}

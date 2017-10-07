package Presentation;

import Domain.Shape;
import Domain.Sphere;
import BusinessLogic.ShapeManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OverviewPanel extends Panel {

    private JButton loadButton, saveButton, calculateTotalButton, deleteButton, editButton, newShapeButton;
    private JTextField totalVolumeField, infoBox;
    private JScrollPane shapeListField;
    private JComboBox newShapeSelectorField;
    private JLabel newShapeSelectorLabel, shapeListLabel, totalVolumeLabel;

    public OverviewPanel(int rows, int columns) {
        super(rows, columns);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        this.infoBox = new JTextField(10);
        this.infoBox.setEditable(false);
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.infoBox, gridBagConstraints);

        this.newShapeSelectorField = new JComboBox();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.newShapeSelectorField, gridBagConstraints);

        this.newShapeButton = new JButton("Add");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.newShapeButton, gridBagConstraints);

        JList<Shape> shapeList = new JList(ShapeManager.getShapes().toArray());
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        shapeList.setLayoutOrientation(JList.VERTICAL);
        shapeList.setVisibleRowCount(-1);

        this.shapeListField = new JScrollPane(shapeList);
        this.shapeListField.setPreferredSize(new Dimension(250, 80));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.shapeListField, gridBagConstraints);

        this.saveButton = new JButton("Save");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.saveButton, gridBagConstraints);

        this.loadButton = new JButton("Load");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.loadButton, gridBagConstraints);

        this.editButton = new JButton("Edit");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.editButton, gridBagConstraints);

        this.deleteButton = new JButton("Delete");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.deleteButton, gridBagConstraints);

        this.calculateTotalButton = new JButton("Calculate total");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.calculateTotalButton, gridBagConstraints);
    }

}

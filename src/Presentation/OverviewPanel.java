package Presentation;

import Domain.Shape;
import BusinessLogic.ShapeManager;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class OverviewPanel extends JPanel {

    public static final String
            INFO_INFO = "info",
            INFO_SUCCESS = "success",
            INFO_WARNING = "warning",
            INFO_DANGER = "danger",
            INFO_DEFAULT = "";

    private JButton loadButton,
            saveButton,
            calculateTotalButton,
            deleteButton,
            editButton,
            newShapeButton,
            importButton,
            exportButton;
    private JTextField infoBox;
    private JList<Shape> shapeList;
    private JScrollPane shapeListField;
    private JComboBox<String> newShapeSelectorField;
    private OverviewButtonHandler overviewButtonHandler;
    private ShapeManager shapeManager;

    public OverviewPanel(ShapeManager shapeManager) {
        super();

        this.overviewButtonHandler = new OverviewButtonHandler(this);
        this.shapeManager = shapeManager;

        this.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        this.infoBox = new JTextField();
        this.infoBox.setEditable(false);
        this.infoBox.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.infoBox, gridBagConstraints);

        this.newShapeSelectorField = new JComboBox();

        for (String item : this.shapeManager.getShapeTypes()) {
            this.newShapeSelectorField.addItem(item);
        }

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.newShapeSelectorField, gridBagConstraints);

        this.newShapeButton = new JButton("Add");
        this.newShapeButton.setActionCommand("newShape");
        this.newShapeButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.newShapeButton, gridBagConstraints);

        this.shapeList = new JList(this.shapeManager.getShapes().toArray());
        this.shapeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.shapeList.setLayoutOrientation(JList.VERTICAL);
        this.shapeList.setVisibleRowCount(-1);

        this.shapeListField = new JScrollPane(shapeList);
        this.shapeListField.setPreferredSize(new Dimension(250, 150));

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
        this.saveButton.setActionCommand("saveShapes");
        this.saveButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.saveButton, gridBagConstraints);

        this.loadButton = new JButton("Load");
        this.loadButton.setActionCommand("loadShapes");
        this.loadButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.loadButton, gridBagConstraints);

        this.exportButton = new JButton("Export");
        this.exportButton.setActionCommand("exportShapes");
        this.exportButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.exportButton, gridBagConstraints);

        this.importButton = new JButton("Import");
        this.importButton.setActionCommand("importShapes");
        this.importButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.importButton, gridBagConstraints);

        this.editButton = new JButton("Edit");
        this.editButton.setActionCommand("editShape");
        this.editButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.editButton, gridBagConstraints);

        this.deleteButton = new JButton("Delete");
        this.deleteButton.setActionCommand("deleteShape");
        this.deleteButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.deleteButton, gridBagConstraints);

        this.calculateTotalButton = new JButton("Calculate total");
        this.calculateTotalButton.setActionCommand("calculateTotalVolume");
        this.calculateTotalButton.addActionListener(this.overviewButtonHandler);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        this.add(this.calculateTotalButton, gridBagConstraints);
    }

    /**
     * Set the info for the info box.
     *
     * @param info String
     */
    public void setInfo(String info) {
        this.infoBox.setText(info);
    }

    /**
     * Set the info for the info box with a given type to apply a color to the text.
     *
     * @param info String the text to display
     * @param type String the type of text. Available types: info, success, warning, danger and none.
     */
    public void setInfo(String info, String type) {
        switch (type) {
            case OverviewPanel.INFO_WARNING:
                this.infoBox.setBackground(Color.decode("#b79f2a"));
                this.infoBox.setForeground(Color.BLACK);
                break;
            case OverviewPanel.INFO_DANGER:
                this.infoBox.setBackground(Color.decode("#b7432a"));
                this.infoBox.setForeground(Color.WHITE);
                break;
            case OverviewPanel.INFO_INFO:
                this.infoBox.setBackground(Color.decode("#2a7eb7"));
                this.infoBox.setForeground(Color.WHITE);
                break;
            case OverviewPanel.INFO_SUCCESS:
                this.infoBox.setBackground(Color.decode("#2ab767"));
                this.infoBox.setForeground(Color.WHITE);
                break;
            default:
                this.infoBox.setBackground(Color.WHITE);
                this.infoBox.setForeground(Color.BLACK);
                break;
        }

        this.setInfo(info);
    }

    /**
     * Get the shape manager.
     *
     * @return ShapeManager
     */
    public ShapeManager getShapeManager() {
        return shapeManager;
    }

    /**
     * Get the selected shape from the shape list.
     * @return Shape
     */
    public Shape getSelectedShape() {
        return this.shapeList.getSelectedValue();
    }

    /**
     * Refresh the contents of the shape list.
     */
    public void refreshShapeList() {
        this.shapeList.setListData(new Vector(this.shapeManager.getShapes()));
    }

    /**
     * Get the value of the new shape selector.
     * @return String
     */
    public String getNewShapeSelectorValue() {
        return this.newShapeSelectorField.getSelectedItem().toString();
    }
}

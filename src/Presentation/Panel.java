package Presentation;

import javax.swing.*;
import java.awt.*;

abstract public class Panel extends JPanel {

    public Panel(int rows, int columns) {
        this.setLayout(new BorderLayout(rows, columns));
    }

}

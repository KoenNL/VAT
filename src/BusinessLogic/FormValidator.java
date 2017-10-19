package BusinessLogic;

import javax.swing.*;
import java.awt.*;

public class FormValidator {

    /**
     * Check if the current value in the given textfield is a valid double.
     * Color the label text red if field is invalid.
     *
     * @param textField JTextField
     * @param label     JLabel
     * @return boolean
     */
    public static boolean validateDouble(JTextField textField, JLabel label) {
        if (FormValidator.validateDouble(textField)) {
            label.setForeground(Color.BLACK);
            return true;
        }
        label.setForeground(Color.decode("#b7432a"));
        return false;
    }

    /**
     * Check if the current value in the given textfield is a valid double.
     *
     * @param textField JTextField
     * @return boolean
     */
    public static boolean validateDouble(JTextField textField) {
        try {
            if (textField.getText().isEmpty()) {
                return false;
            }

            double value = Double.parseDouble(textField.getText().replace(',', '.'));

            if (value <= 0.0) {
                return false;
            }
        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }

}

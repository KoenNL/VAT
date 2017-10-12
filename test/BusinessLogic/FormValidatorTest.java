package BusinessLogic;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class FormValidatorTest {
    @Test
    public void validateDouble() throws Exception {

        JTextField textField = new JTextField();

        assertFalse(FormValidator.validateDouble(textField));

        textField.setText("string");
        assertFalse(FormValidator.validateDouble(textField));

        textField.setText("0.00");
        assertFalse(FormValidator.validateDouble(textField));

        textField.setText("0");
        assertFalse(FormValidator.validateDouble(textField));

        textField.setText("0,04");
        assertTrue(FormValidator.validateDouble(textField));

        textField.setText("0.04");
        assertTrue(FormValidator.validateDouble(textField));

        textField.setText("4");
        assertTrue(FormValidator.validateDouble(textField));
    }

}
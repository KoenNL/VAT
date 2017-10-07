package BusinessLogic;

import javax.swing.*;

public class ExceptionHandler {

    private static boolean debug = false;

    public static void setDebug(boolean debug) {
        ExceptionHandler.debug = debug;
    }

    public static void handleException(Exception exception, String friendlyMessage) {
        if (ExceptionHandler.debug) {
            System.out.println(exception.getMessage());
        }

        JOptionPane.showMessageDialog(null, friendlyMessage);

        System.exit(1);
    }

}

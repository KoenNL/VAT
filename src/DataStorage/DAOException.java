package DataStorage;

import BusinessLogic.CustomException;

public class DAOException extends CustomException {

    public DAOException(String message, Exception exception) {
        super(message, exception);
    }

    public DAOException(String message) {
        super(message);
    }

}

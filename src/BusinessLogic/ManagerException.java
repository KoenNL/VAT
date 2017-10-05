package BusinessLogic;

public class ManagerException extends CustomException {
    public ManagerException(String friendlyMessage, Exception exception) {
        super(friendlyMessage, exception);
    }

    public ManagerException(String friendlyMessage) {
        super(friendlyMessage);
    }
}

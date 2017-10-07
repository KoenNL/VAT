package BusinessLogic;

public class BusinessLogicException extends CustomException {
    public BusinessLogicException(String friendlyMessage, Exception exception) {
        super(friendlyMessage, exception);
    }

    public BusinessLogicException(String friendlyMessage) {
        super(friendlyMessage);
    }
}

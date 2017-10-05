package BusinessLogic;

abstract public class CustomException extends Exception {
    private final String friendlyMessage;
    private Exception exception;

    public CustomException(String friendlyMessage, Exception exception) {
        this.friendlyMessage = friendlyMessage;
        this.exception = exception;
    }

    public CustomException(String friendlyMessage) {
        this.friendlyMessage = friendlyMessage;
    }

    public String getFriendlyMessage() {
        return friendlyMessage;
    }

    public Exception getException() {
        return exception;
    }
}

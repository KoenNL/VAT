package Presentation;

import BusinessLogic.CustomException;

public class PresentationException extends CustomException {
    public PresentationException(String friendlyMessage, Exception exception) {
        super(friendlyMessage, exception);
    }

    public PresentationException(String friendlyMessage) {
        super(friendlyMessage);
    }
}

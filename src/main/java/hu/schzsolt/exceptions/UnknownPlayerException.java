package hu.schzsolt.exceptions;

public class UnknownPlayerException extends Exception {

    public UnknownPlayerException() {
    }

    public UnknownPlayerException(String message) {
        super(message);
    }
}

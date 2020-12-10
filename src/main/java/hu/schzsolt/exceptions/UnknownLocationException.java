package hu.schzsolt.exceptions;

import lombok.Data;

@Data
public class UnknownLocationException extends Exception {

    public UnknownLocationException() {
    }

    public UnknownLocationException(String message) {
        super(message);
    }
}
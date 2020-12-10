package hu.schzsolt.exceptions;

import hu.schzsolt.model.Match;
import lombok.Data;

@Data
public class UnknownMatchException extends Exception {

    private Match match;

    public UnknownMatchException() {
    }

    public UnknownMatchException(String message, Match match) {
        super(message);
        this.match = match;
    }


    public UnknownMatchException(String message) {
        super(message);
    }
}

package hu.schzsolt.exceptions;

import hu.schzsolt.model.Match;
import lombok.Data;

public class UnknownMatchException extends Exception {

    private Match match;

    public UnknownMatchException(Match match) {
        this.match = match;
    }

    public UnknownMatchException(String message, Match match) {
        super(message);
        this.match = match;
    }


    public UnknownMatchException(String message) {
        super(message);
    }
}

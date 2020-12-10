package hu.schzsolt.exceptions;

import lombok.Data;

@Data
public class UnknownGoalException extends Exception {

    public UnknownGoalException() {
    }

    public UnknownGoalException(String message) {
        super(message);
    }
}
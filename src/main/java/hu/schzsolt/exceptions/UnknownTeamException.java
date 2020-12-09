package hu.schzsolt.exceptions;
import hu.schzsolt.model.Team;
import lombok.Data;

@Data
public class UnknownTeamException extends Exception {

    private Team team;

    public UnknownTeamException() {
    }

    public UnknownTeamException(String message, Team team) {
        super(message);
        this.team = team;
    }


    public UnknownTeamException(String message) {
        super(message);
    }
}
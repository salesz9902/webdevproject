package hu.schzsolt.exceptions;
import hu.schzsolt.model.Player;
import lombok.Data;

@Data
public class UnknownPlayerException extends Exception {

    private Player player;

    public UnknownPlayerException() {
    }

    public UnknownPlayerException(String message, Player player) {
        super(message);
        this.player = player;
    }


    public UnknownPlayerException(String message) {
        super(message);
    }
}

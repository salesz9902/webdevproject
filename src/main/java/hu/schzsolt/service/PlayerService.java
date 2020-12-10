package hu.schzsolt.service;

import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.model.Player;

import java.util.Collection;

public interface PlayerService {

    Collection<Player> getAllPlayer();

    void recordPlayer(Player player) throws UnknownPlayerException;
    void deletePlayer(Integer player) throws UnknownPlayerException;
}
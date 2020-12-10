package hu.schzsolt.dao;

import hu.schzsolt.model.Player;

import java.util.Collection;

import hu.schzsolt.exceptions.UnknownPlayerException;

/**
 * DAO = Data Access Object
 *
 * CRUD Methods:
 *  - Create
 *  - Read
 *  - Update
 *  - Delete
 */
public interface PlayerDao {

    void createPlayer(Player player) throws UnknownPlayerException;
    Collection<Player> readAll();

    void deletePlayer(Integer player) throws UnknownPlayerException;
}

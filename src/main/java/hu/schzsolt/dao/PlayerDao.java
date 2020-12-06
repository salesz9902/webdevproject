package hu.schzsolt.dao;

import hu.schzsolt.model.Player;

import java.util.Collection;

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

    void createPlayer(Player player);
    Collection<Player> readAll();

    void deleteAddress(Player player);
}

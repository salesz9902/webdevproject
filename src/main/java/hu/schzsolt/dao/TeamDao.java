package hu.schzsolt.dao;

import hu.schzsolt.model.Team;

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
public interface TeamDao {

    void createTeam(Team team);
    Collection<Team> readAll();

    void deleteTeam(Team team);
}
package hu.schzsolt.dao;

import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.exceptions.UnknownTeamException;
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

    void createTeam(Team team) throws UnknownPlayerException, UnknownTeamException;
    Collection<Team> readAll();

    void deleteTeam(Team team) throws UnknownPlayerException, UnknownTeamException;
}
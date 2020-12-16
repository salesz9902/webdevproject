package hu.schzsolt.dao;

import hu.schzsolt.exceptions.*;
import hu.schzsolt.model.Match;

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
public interface MatchDao {

    void createMatch(Match match) throws UnknownTeamException;
    Collection<Match> readAll();

    void deleteMatch(String id) throws UnknownMatchException;
}

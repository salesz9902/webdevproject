package hu.schzsolt.service;

import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.exceptions.UnknownTeamException;
import hu.schzsolt.model.Team;

import java.util.Collection;

public interface TeamService {

    Collection<Team> getAllTeam();

    void recordTeam(Team team) throws UnknownTeamException;
    void deleteTeam(Integer team) throws UnknownTeamException;
}

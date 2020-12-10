package hu.schzsolt.service;

import hu.schzsolt.dao.TeamDao;
import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.exceptions.UnknownTeamException;
import hu.schzsolt.model.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{

    private final TeamDao teamDao;

    @Override
    public Collection<Team> getAllTeam() {
        return teamDao.readAll();
    }

    @Override
    public void recordTeam(Team team) throws UnknownTeamException, UnknownPlayerException {
        teamDao.createTeam(team);
    }

    @Override
    public void deleteTeam(Integer team) throws UnknownTeamException, UnknownPlayerException {
        teamDao.deleteTeam(team);
    }
}
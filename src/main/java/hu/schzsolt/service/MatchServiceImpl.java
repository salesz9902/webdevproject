package hu.schzsolt.service;

import hu.schzsolt.dao.MatchDao;
import hu.schzsolt.exceptions.*;
import hu.schzsolt.model.Match;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService{

    private final MatchDao matchDao;

    @Override
    public Collection<Match> getAllMatch() {
        return matchDao.readAll();
    }

    @Override
    public void recordMatch(Match match) throws UnknownMatchException, UnknownPlayerException, UnknownTeamException, UnknownDisposalException, UnknownGoalException, UnknownLocationException {
        matchDao.createMatch(match);
    }

    @Override
    public void deleteMatch(String match) throws UnknownMatchException, UnknownPlayerException {
        matchDao.deleteMatch(match);
    }
}
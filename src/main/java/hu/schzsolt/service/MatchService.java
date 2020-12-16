package hu.schzsolt.service;

import hu.schzsolt.exceptions.*;
import hu.schzsolt.model.Match;

import java.util.Collection;

public interface MatchService {

    Collection<Match> getAllMatch();

    void recordMatch(Match match) throws UnknownTeamException;
    void deleteMatch(String id) throws UnknownMatchException;
}


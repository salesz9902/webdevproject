package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.MatchEntity;
import hu.schzsolt.dao.entity.TeamEntity;
import hu.schzsolt.exceptions.*;
import hu.schzsolt.model.Match;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchDaoImpl implements MatchDao{

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    @Override
    public void createMatch(Match match) throws UnknownTeamException {
        MatchEntity matchEntity;

        matchEntity = MatchEntity.builder()
                .team1(queryTeam(match.getTeam1()))
                .team1Location(match.getTeam1Location())
                .team2(queryTeam(match.getTeam2()))
                .team2Location(match.getTeam2Location())
                .homeTeam(match.getHomeTeam())
                .winnerScore(match.getWinnerScore())
                .loserScore(match.getLoserScore())
                .winnerTeam(match.getWinnerTeam())
                .build();
        log.info("MatchEntity: {}", matchEntity);
        try {
            matchRepository.save(matchEntity);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    protected TeamEntity queryTeam(Integer team) throws UnknownTeamException {

        Optional<TeamEntity> teamEntity = teamRepository.findById(team).stream()
                .findFirst();
        if(!teamEntity.isPresent()){
            throw new UnknownTeamException();
        }
        log.trace("Team Entity: {}", teamEntity);
        return teamEntity.get();
    }

    @Override
    public Collection<Match> readAll() {
        return StreamSupport.stream(matchRepository.findAll().spliterator(),false)
                .map(entity -> new Match(
                        entity.getTeam1().getId(),
                        entity.getTeam1Location(),
                        entity.getTeam2().getId(),
                        entity.getTeam2Location(),
                        entity.getHomeTeam(),
                        entity.getWinnerScore(),
                        entity.getLoserScore(),
                        entity.getWinnerTeam()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMatch(String id) throws UnknownMatchException {
        Optional<MatchEntity> matchEntity = StreamSupport.stream(matchRepository.findAll().spliterator(),false).filter(
                entity -> id.equals(entity.getId())
        ).findAny();
        if (matchEntity.isEmpty()){
            throw new UnknownMatchException(String.format("Match with this ID Not Found %s",id));
        }
        matchRepository.delete(matchEntity.get());
    }
}
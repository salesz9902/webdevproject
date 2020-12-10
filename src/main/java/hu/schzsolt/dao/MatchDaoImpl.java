package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.MatchEntity;
import hu.schzsolt.dao.entity.TeamEntity;
import hu.schzsolt.dao.entity.StatsEntity;
import hu.schzsolt.exceptions.*;
import hu.schzsolt.model.Team;
import hu.schzsolt.model.Match;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchDaoImpl implements MatchDao{

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final StatsRepository statsRepository;

    @Override
    public void createMatch(Match match) throws UnknownLocationException, UnknownTeamException, UnknownGoalException, UnknownDisposalException {
        MatchEntity matchEntity;

        matchEntity = MatchEntity.builder()
                .location(queryLocation(match.getLocation()))
                .team1(queryTeam(match.getTeam1()))
                .team1Location(match.getTeam1Location())
                .team2(queryTeam(match.getTeam2()))
                .team2Location(match.getTeam2Location())
                .homeTeam(match.getHomeTeam())
                .winnerScore(match.getWinnerScore())
                .loserScore(match.getLoserScore())
                .winnerTeam(match.getWinnerTeam())
                .goals(queryGoal(match.getGoals()))
                .disposals(queryDisposal(match.getDisposals()))
                .build();
        log.info("MatchEntity: {}", matchEntity);
        try {
            matchRepository.save(matchEntity);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    protected StatsEntity queryLocation(String location) throws UnknownLocationException {

        Optional<StatsEntity> statsEntity = statsRepository.findStatsEntityByLocation(location).stream()
                .findFirst();
        if(!statsEntity.isPresent()){
            throw new UnknownLocationException();
        }
        log.trace("Stats Entity: {}", statsEntity);
        return statsEntity.get();
    }

    protected StatsEntity queryGoal(Integer goal) throws UnknownGoalException {

        Optional<StatsEntity> statsEntity = statsRepository.findStatsEntityByGoals(goal).stream()
                .findFirst();
        if(!statsEntity.isPresent()){
            throw new UnknownGoalException();
        }
        log.trace("Stats Entity: {}", statsEntity);
        return statsEntity.get();
    }

    protected StatsEntity queryDisposal(Integer disposal) throws UnknownDisposalException {

        Optional<StatsEntity> statsEntity = statsRepository.findStatsEntityByDisposals(disposal).stream()
                .findFirst();
        if(!statsEntity.isPresent()){
            throw new UnknownDisposalException();
        }
        log.trace("Stats Entity: {}", statsEntity);
        return statsEntity.get();
    }

    protected TeamEntity queryTeam(String team) throws UnknownTeamException {

        Optional<TeamEntity> teamEntity = teamRepository.findTeamEntityByTeamName(team).stream()
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
                        entity.getLocation().getLocation(),
                        entity.getTeam1().getTeamName(),
                        entity.getTeam1Location(),
                        entity.getTeam2().getTeamName(),
                        entity.getTeam2Location(),
                        entity.getHomeTeam(),
                        entity.getWinnerScore(),
                        entity.getLoserScore(),
                        entity.getWinnerTeam(),
                        entity.getGoals().getGoals(),
                        entity.getKicks().getKicks(),
                        entity.getDisposals().getDisposals()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMatch(String id) throws UnknownMatchException {
        MatchEntity matchEntity = queryMatch(id);
        log.info("Deleting inventory {}", matchEntity);
        matchRepository.delete(matchEntity);
    }

    protected MatchEntity queryMatch(String id) throws UnknownMatchException {
        Optional<MatchEntity> matchEntity = matchRepository.findById(id);

        if (!matchEntity.isPresent())
            throw new UnknownMatchException();

        return matchEntity.get();
    }
}
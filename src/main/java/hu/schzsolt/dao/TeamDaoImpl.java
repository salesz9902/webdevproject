package hu.schzsolt.dao;


import hu.schzsolt.dao.entity.PlayerEntity;
import hu.schzsolt.dao.entity.TeamEntity;
import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.exceptions.UnknownTeamException;
import hu.schzsolt.model.Team;
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
public class TeamDaoImpl implements TeamDao{

    private final TeamRepository teamRepository;

    @Override
    public void createTeam(Team team) throws UnknownTeamException {
        TeamEntity teamEntity;

        teamEntity = TeamEntity.builder()
                .teamName(team.getName())
                .build();
        log.info("TeamEntity: {}", teamEntity);
        try {
            teamRepository.save(teamEntity);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public Collection<Team> readAll() {
        return StreamSupport.stream(teamRepository.findAll().spliterator(),false)
                .map(entity -> new Team(
                        entity.getTeamName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeam(Integer id) throws UnknownTeamException {
        TeamEntity teamEntity = queryTeam(id);
        log.info("Deleting inventory {}", teamEntity);
        teamRepository.delete(teamEntity);
    }

    protected TeamEntity queryTeam(Integer id) throws UnknownTeamException {
        Optional<TeamEntity> teamEntity = teamRepository.findById(id);

        if (!teamEntity.isPresent())
            throw new UnknownTeamException();

        return teamEntity.get();
    }

}

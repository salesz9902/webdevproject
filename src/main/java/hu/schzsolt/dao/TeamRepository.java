package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.StatsEntity;
import hu.schzsolt.dao.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {
    Collection<TeamEntity> findTeamEntityByTeamName(String team);
}


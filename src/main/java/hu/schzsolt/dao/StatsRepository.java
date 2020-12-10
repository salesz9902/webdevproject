package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.StatsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface StatsRepository extends CrudRepository<StatsEntity, Integer> {
    Collection<StatsEntity> findStatsEntityByLocation(String location);
    Collection<StatsEntity> findStatsEntityByGoals(Integer goal);
    Collection<StatsEntity> findStatsEntityByDisposals(Integer disposal);
}

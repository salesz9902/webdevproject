package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {
}


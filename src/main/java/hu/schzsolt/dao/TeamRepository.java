package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {
    @Override
    Optional<TeamEntity> findById(Integer integer);
}


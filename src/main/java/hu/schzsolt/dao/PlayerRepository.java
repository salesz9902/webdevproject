package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
}


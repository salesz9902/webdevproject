package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.MatchEntity;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<MatchEntity, String> {
}

package hu.schzsolt.model;

import hu.schzsolt.dao.entity.StatsEntity;
import hu.schzsolt.dao.entity.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Team {

    private Integer id;
    private String name;
}

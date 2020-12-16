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
public class Match {
    private Integer team1;
    private String team1Location;
    private Integer team2;
    private String team2Location;
    private Integer homeTeam;
    private Integer winnerScore;
    private Integer loserScore;
    private Integer winnerTeam;
}

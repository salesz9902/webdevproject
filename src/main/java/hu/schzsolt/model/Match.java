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
    //stats
    private String location;
    //team
    private String team1;
    private String team1Location;
    //team
    private String team2;
    private String team2Location;
    private Integer homeTeam;
    private Integer winnerScore;
    private Integer loserScore;

    private Integer winnerTeam;

    //stats
    private Integer goals;
    private Integer kicks;
    private Integer disposals;
}

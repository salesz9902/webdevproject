package hu.schzsolt.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {
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

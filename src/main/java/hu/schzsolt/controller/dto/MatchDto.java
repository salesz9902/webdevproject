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
    private String id;
    private Integer team1;
    private String team1Location;
    private Integer team2;
    private String team2Location;
    private Integer homeTeam;
    private Integer winnerScore;
    private Integer loserScore;
    private Integer winnerTeam;
}

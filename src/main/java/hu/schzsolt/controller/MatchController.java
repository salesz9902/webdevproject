package hu.schzsolt.controller;

import hu.schzsolt.controller.dto.MatchDto;
import hu.schzsolt.exceptions.*;
import hu.schzsolt.model.Match;
import hu.schzsolt.service.MatchService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MatchController {

    private final MatchService service;

    @GetMapping("/match")
    public Collection<MatchDto> listMatches() {
        return service.getAllMatch()
                .stream()
                .map(model -> MatchDto.builder()
                        .location(model.getLocation())
                        .team1(model.getTeam1())
                        .team1Location(model.getTeam1Location())
                        .team2(model.getTeam2())
                        .team2Location(model.getTeam2Location())
                        .homeTeam(model.getHomeTeam())
                        .winnerScore(model.getWinnerScore())
                        .loserScore(model.getLoserScore())
                        .winnerTeam(model.getWinnerTeam())
                        .goals(model.getGoals())
                        .kicks(model.getKicks())
                        .disposals(model.getDisposals())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/match")
    public void record(@RequestBody MatchDto matchDto) {
        try {
            service.recordMatch(new Match(
                    matchDto.getLocation(),
                    matchDto.getTeam1(),
                    matchDto.getTeam1Location(),
                    matchDto.getTeam2(),
                    matchDto.getTeam2Location(),
                    matchDto.getHomeTeam(),
                    matchDto.getWinnerScore(),
                    matchDto.getLoserScore(),
                    matchDto.getWinnerTeam(),
                    matchDto.getGoals(),
                    matchDto.getKicks(),
                    matchDto.getDisposals()
            ));
        } catch (UnknownMatchException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (UnknownPlayerException | UnknownLocationException | UnknownTeamException | UnknownGoalException | UnknownDisposalException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/match")
    private void deleteById(@RequestBody String id) {
        try {
            service.deleteMatch(id);
        } catch (UnknownMatchException | UnknownPlayerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

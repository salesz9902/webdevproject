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

    @GetMapping("/match/list")
    public Collection<MatchDto> listMatches() {
        return service.getAllMatch()
                .stream()
                .map(model -> MatchDto.builder()
                        .id(model.getId())
                        .team1(model.getTeam1())
                        .team1Location(model.getTeam1Location())
                        .team2(model.getTeam2())
                        .team2Location(model.getTeam2Location())
                        .homeTeam(model.getHomeTeam())
                        .winnerScore(model.getWinnerScore())
                        .loserScore(model.getLoserScore())
                        .winnerTeam(model.getWinnerTeam())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/match/record")
    public void record(@RequestBody MatchDto matchDto) {
        try {
            service.recordMatch(new Match(
                    matchDto.getId(),
                    matchDto.getTeam1(),
                    matchDto.getTeam1Location(),
                    matchDto.getTeam2(),
                    matchDto.getTeam2Location(),
                    matchDto.getHomeTeam(),
                    matchDto.getWinnerScore(),
                    matchDto.getLoserScore(),
                    matchDto.getWinnerTeam()
            ));
        } catch (UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/match/delete")
    public void deleteMatch(@RequestBody MatchDto matchDto){
        try{
            service.deleteMatch(matchDto.getId());
        } catch(UnknownMatchException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

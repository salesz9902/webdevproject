package hu.schzsolt.controller;

import hu.schzsolt.controller.dto.TeamDto;
import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.exceptions.UnknownTeamException;
import hu.schzsolt.model.Team;
import hu.schzsolt.service.TeamService;
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
public class TeamController {

    private final TeamService service;

    @GetMapping("/team")
    public Collection<TeamDto> listTeams() {
        return service.getAllTeam()
                .stream()
                .map(model -> TeamDto.builder()
                        .teamName(model.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/team")
    public void record(@RequestBody TeamDto teamDto) {
        try {
            service.recordTeam(new Team(
                    teamDto.getTeamName()
            ));
        } catch (UnknownPlayerException | UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}


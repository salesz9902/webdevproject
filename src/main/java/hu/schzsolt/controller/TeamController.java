package hu.schzsolt.controller;

import hu.schzsolt.controller.dto.TeamDto;
import hu.schzsolt.exceptions.UnknownTeamException;
import hu.schzsolt.model.Team;
import hu.schzsolt.service.TeamService;
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

    @GetMapping("/teams/list")
    public Collection<TeamDto> listTeam(){
        return service.getAllTeam().stream()
                .map(model -> new TeamDto(
                        model.getId(),
                        model.getName()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/team/record")
    public void record(@RequestBody TeamDto teamDto) {
        try {
            service.recordTeam(new Team(
                    teamDto.getId(),
                    teamDto.getTeamName()
            ));
        } catch (UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/team/update")
    public void updateTeam(@RequestBody TeamDto teamDto){
        try {
            service.updateTeam(new Team(
                    teamDto.getId(),
                    teamDto.getTeamName()
            ));
        } catch (UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/team/delete")
    private void deleteById(@RequestBody Integer id) {
        try {
            service.deleteTeam(id);
        } catch (UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}


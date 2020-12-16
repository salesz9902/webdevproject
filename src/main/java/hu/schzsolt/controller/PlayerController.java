package hu.schzsolt.controller;

import hu.schzsolt.controller.dto.PlayerDto;
import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.model.Player;
import hu.schzsolt.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService service;

    @GetMapping("/player")
    public Collection<PlayerDto> listPlayers() {
        return service.getAllPlayer()
                .stream()
                .map(model -> PlayerDto.builder()
                        .firstName(model.getFirstName())
                        .lastName(model.getLastName())
                        .height(model.getHeight())
                        .weight(model.getWeight())
                        .birthDate(model.getBirthDate().toString())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/player")
    public void record(@RequestBody PlayerDto playerDto) {
        try {
            service.recordPlayer(new Player(
                    playerDto.getFirstName(),
                    playerDto.getLastName(),
                    playerDto.getHeight(),
                    playerDto.getWeight(),
                    Timestamp.valueOf(playerDto.getBirthDate())
            ));
        } catch (UnknownPlayerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/player")
    private void deleteById(@RequestBody Integer id) {
        try {
            service.deletePlayer(id);
        } catch ( UnknownPlayerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

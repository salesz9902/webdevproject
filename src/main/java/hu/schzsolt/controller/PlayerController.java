package hu.schzsolt.controller;

import hu.schzsolt.controller.dto.PlayerDto;
import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.model.Player;
import hu.schzsolt.service.PlayerService;
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
public class PlayerController {

    private final PlayerService service;

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World", required = false) String name) {
        return String.format("Hello %s!", name);
    }

    @ApiOperation("Say Hello from Path")
    @GetMapping("/hello/{name}")
    public String helloPath(@PathVariable("name") String name) {
        return String.format("Hello %s!", name);
    }


    @GetMapping("/player")
    public Collection<PlayerDto> listPlayers() {
        return service.getAllPlayer()
                .stream()
                .map(model -> PlayerDto.builder()
                        .firstName(model.getFirstName())
                        .lastName(model.getLastName())
                        .height(model.getHeight())
                        .weight(model.getWeight())
                        .birthDate(model.getBirthDate())
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
                    playerDto.getBirthDate()
            ));
        } catch (UnknownPlayerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

package hu.schzsolt.controller;

import hu.schzsolt.controller.dto.PlayerDto;
import hu.schzsolt.service.PlayerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

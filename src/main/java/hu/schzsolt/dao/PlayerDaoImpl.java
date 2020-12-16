package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.PlayerEntity;
import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.model.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerDaoImpl implements PlayerDao{

    private final PlayerRepository playerRepository;

    @Override
    public void createPlayer(Player player) throws UnknownPlayerException{
        PlayerEntity playerEntity;

        playerEntity = PlayerEntity.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .height(player.getHeight())
                .weight(player.getWeight())
                .dateOfBirth(player.getBirthDate())
                .build();
        log.info("PlayerEntity: {}", playerEntity);
        try {
            playerRepository.save(playerEntity);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public Collection<Player> readAll() {
        return StreamSupport.stream(playerRepository.findAll().spliterator(),false)
                .map(entity -> new Player(
                        entity.getFirstName(),
                        entity.getLastName(),
                        entity.getHeight(),
                        entity.getWeight(),
                        entity.getDateOfBirth()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlayer(Integer id) throws UnknownPlayerException {
        PlayerEntity playerEntity = queryPlayer(id);
        log.info("Deleting inventory {}", playerEntity);
        playerRepository.delete(playerEntity);
    }

    protected PlayerEntity queryPlayer(Integer id) throws UnknownPlayerException {
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);

        if (!playerEntity.isPresent())
            throw new UnknownPlayerException();

        return playerEntity.get();
    }

}

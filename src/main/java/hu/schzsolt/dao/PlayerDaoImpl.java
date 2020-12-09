package hu.schzsolt.dao;

import hu.schzsolt.dao.entity.PlayerEntity;
import hu.schzsolt.dao.entity.StatsEntity;
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
    private final TeamRepository teamRepository;

    @Override
    public void createPlayer(Player player) throws UnknownPlayerException {
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
    public void deletePlayer(Player player) throws UnknownPlayerException {
        Optional<PlayerEntity> playerEntity = StreamSupport.stream(playerRepository.findAll().spliterator(),false).filter(
                entity ->{
                            return player.getFirstName().equals(entity.getFirstName())  &&
                            player.getLastName().equals(entity.getLastName()) &&
                            player.getHeight().equals(entity.getHeight()) &&
                            player.getWeight().equals(entity.getWeight()) &&
                            player.getBirthDate().equals(entity.getDateOfBirth());
                }
        ).findAny();
        if(!playerEntity.isPresent()){
            throw new UnknownPlayerException(String.format("Player Not Found %s",player), player);
        }
        playerRepository.delete(playerEntity.get());
    }


}

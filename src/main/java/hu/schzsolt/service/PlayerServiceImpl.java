package hu.schzsolt.service;


import hu.schzsolt.dao.PlayerDao;
import hu.schzsolt.exceptions.UnknownPlayerException;
import hu.schzsolt.model.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{

    private final PlayerDao playerDao;

    @Override
    public Collection<Player> getAllPlayer() {
        return playerDao.readAll();
    }

    @Override
    public void recordPlayer(Player player) throws UnknownPlayerException {
        playerDao.createPlayer(player);
    }

    @Override
    public void deletePlayer(Player player) throws UnknownPlayerException {
       playerDao.deletePlayer(player);
    }
}

package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<Game> findAll() {
        Set<Game> gameSet = new HashSet<>();
        gameRepository.findAll().iterator().forEachRemaining(gameSet::add);
        return gameSet;
    }

    @Override
    public Set<Game> findByNameContainingIgnoreCase(String name) {
        if(name.length() == 0){
            Set<Game> gameSet = new HashSet<>();
            gameRepository.findAll().iterator().forEachRemaining(gameSet::add);
            return gameSet;
        }else {
            return gameRepository.findByNameContainingIgnoreCase(name);
        }
    }

    @Override
    public Game add(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game update(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void delete(Game game) {
        gameRepository.delete(game);
    }
}

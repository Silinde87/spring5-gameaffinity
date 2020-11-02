package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.domain.Platform;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;
import spring5.silinde87.gameaffinity.backend.repositories.PlatformRepository;

import java.util.*;

@Service
public class PlatformServiceImpl implements PlatformService {

    private final PlatformRepository platformRepository;
    private final GameRepository gameRepository;

    public PlatformServiceImpl(PlatformRepository platformRepository, GameRepository gameRepository) {
        this.platformRepository = platformRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<Platform> findAll() {
        Set<Platform> platformSet = new HashSet<>();
        platformRepository.findAll().iterator().forEachRemaining(platformSet::add);
        return platformSet;
    }

    @Override
    public Platform add(Platform platform) {
        return platformRepository.save(platform);
    }

    @Override
    public Platform update(Platform platform) {
        return platformRepository.save(platform);
    }

    @Override
    public void delete(Platform platform) {
        for (Game game : gameRepository.findAll()){
            if(game.getPlatform().getName().equals(platform.getName())){
                game.setPlatform(null);
                gameRepository.save(game);
            }
        }
        platformRepository.delete(platform);
    }
}

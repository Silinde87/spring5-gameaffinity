package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.repositories.DeveloperRepository;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;

import java.util.*;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final GameRepository gameRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, GameRepository gameRepository) {
        this.developerRepository = developerRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public Collection<Developer> findAll() {
        Set<Developer> developerSet = new HashSet<>();
        developerRepository.findAll().iterator().forEachRemaining(developerSet::add);
        return developerSet;
    }

    @Override
    public Developer add(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Developer update(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public void delete(Developer developer) {
        for(Game game : gameRepository.findAll()){
            if(game.getDeveloper().getName().equals(developer.getName())){
                game.setDeveloper(null);
                gameRepository.save(game);
            }
        }
        developerRepository.delete(developer);
    }
}

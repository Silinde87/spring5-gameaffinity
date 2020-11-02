package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.domain.Producer;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;
import spring5.silinde87.gameaffinity.backend.repositories.ProducerRepository;

import java.util.*;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;
    private final GameRepository gameRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository, GameRepository gameRepository) {
        this.producerRepository = producerRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<Producer> findAll() {
        Set<Producer> producerSet = new HashSet<>();
        producerRepository.findAll().iterator().forEachRemaining(producerSet::add);
        return producerSet;
    }

    @Override
    public Producer add(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public Producer update(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public void delete(Producer producer) {
        for (Game game : gameRepository.findAll()){
            if(game.getProducer().getName().equals(producer.getName())){
                game.setProducer(null);
                gameRepository.save(game);
            }
        }
        producerRepository.delete(producer);
    }
}

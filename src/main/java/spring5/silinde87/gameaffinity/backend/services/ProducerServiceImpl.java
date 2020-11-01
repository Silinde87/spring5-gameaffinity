package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Producer;
import spring5.silinde87.gameaffinity.backend.repositories.ProducerRepository;

import java.util.*;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
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
        producerRepository.delete(producer);
    }
}

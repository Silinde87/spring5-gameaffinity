package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Repository;
import spring5.silinde87.gameaffinity.backend.domain.Producer;
import spring5.silinde87.gameaffinity.backend.repositories.ProducerRepository;

import java.util.Collection;

@Repository
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public Collection<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public Producer add(Producer producer) {
        return producerRepository.insert(producer);
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

package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Repository;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.repositories.DeveloperRepository;

import java.util.Collection;

@Repository
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public Collection<Developer> findAll() {
        return developerRepository.findAll();
    }

    @Override
    public Developer add(Developer developer) {
        return developerRepository.insert(developer);
    }

    @Override
    public Developer update(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public void delete(Developer developer) {
        developerRepository.delete(developer);
    }
}

package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.repositories.DeveloperRepository;

import java.util.*;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
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
        developerRepository.delete(developer);
    }
}

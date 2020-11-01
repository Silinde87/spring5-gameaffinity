package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Platform;
import spring5.silinde87.gameaffinity.backend.repositories.PlatformRepository;

import java.util.*;

@Service
public class PlatformServiceImpl implements PlatformService {

    private final PlatformRepository platformRepository;

    public PlatformServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
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
        platformRepository.delete(platform);
    }
}

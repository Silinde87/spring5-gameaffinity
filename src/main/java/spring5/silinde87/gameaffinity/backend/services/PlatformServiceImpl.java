package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Repository;
import spring5.silinde87.gameaffinity.backend.domain.Platform;
import spring5.silinde87.gameaffinity.backend.repositories.PlatformRepository;

import java.util.Collection;

@Repository
public class PlatformServiceImpl implements PlatformService {

    private final PlatformRepository platformRepository;

    public PlatformServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public Collection<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Platform add(Platform platform) {
        return platformRepository.insert(platform);
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

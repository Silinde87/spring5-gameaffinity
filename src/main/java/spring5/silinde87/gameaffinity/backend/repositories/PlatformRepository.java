package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring5.silinde87.gameaffinity.backend.domain.Platform;

import java.util.*;

public interface PlatformRepository extends MongoRepository<Platform, String> {
    Optional<Platform> findByName(String name);
    Optional<Platform> findByBrand(String brand);
}

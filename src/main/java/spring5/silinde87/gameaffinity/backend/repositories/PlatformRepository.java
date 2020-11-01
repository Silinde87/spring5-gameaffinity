package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5.silinde87.gameaffinity.backend.domain.Platform;

import java.util.*;

public interface PlatformRepository extends CrudRepository<Platform, Long> {

    Optional<Platform> findByName(String name);
    Optional<Platform> findByBrand(String brand);
}

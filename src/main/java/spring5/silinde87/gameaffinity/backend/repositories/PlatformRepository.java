package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring5.silinde87.gameaffinity.backend.domain.Platform;

import java.util.*;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

    Optional<Platform> findByName(String name);
    List<Platform> findByBrand(String brand);
}

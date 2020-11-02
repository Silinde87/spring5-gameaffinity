package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring5.silinde87.gameaffinity.backend.domain.Developer;

import java.util.*;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByName(String name);
}

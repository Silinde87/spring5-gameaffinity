package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5.silinde87.gameaffinity.backend.domain.Developer;

import java.util.*;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {

    Optional<Developer> findByName(String name);
}

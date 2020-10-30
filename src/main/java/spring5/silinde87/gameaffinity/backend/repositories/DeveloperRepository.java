package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring5.silinde87.gameaffinity.backend.domain.Developer;

import java.util.Optional;

public interface DeveloperRepository extends MongoRepository<Developer, String> {

    Optional<Developer> findByName(String name);
}

package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring5.silinde87.gameaffinity.backend.domain.Game;

import java.util.Optional;

public interface GameRepository extends MongoRepository<Game, String> {

    Optional<Game> findByName(String name);
}

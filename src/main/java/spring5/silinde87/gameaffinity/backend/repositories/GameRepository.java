package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5.silinde87.gameaffinity.backend.domain.Game;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findByName(String name);
}

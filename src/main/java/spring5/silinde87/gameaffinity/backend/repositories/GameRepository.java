package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring5.silinde87.gameaffinity.backend.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByName(String name);
}

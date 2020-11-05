package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring5.silinde87.gameaffinity.backend.domain.Game;

import java.util.*;

public interface GameRepository extends JpaRepository<Game, Long> {

    Set<Game> findByNameContainingIgnoreCase(String name);
}

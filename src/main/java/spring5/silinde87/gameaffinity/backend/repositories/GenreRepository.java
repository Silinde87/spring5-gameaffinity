package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5.silinde87.gameaffinity.backend.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    Optional<Genre> findByName(String name);
}

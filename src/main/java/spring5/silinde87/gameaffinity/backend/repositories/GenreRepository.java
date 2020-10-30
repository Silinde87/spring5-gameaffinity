package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring5.silinde87.gameaffinity.backend.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {
    Optional<Genre> findByName(String name);
}

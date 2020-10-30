package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring5.silinde87.gameaffinity.backend.domain.Producer;

import java.util.*;

public interface ProducerRepository extends MongoRepository<Producer, String> {
    Optional<Producer> findByName(String name);
}

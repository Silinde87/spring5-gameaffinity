package spring5.silinde87.gameaffinity.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5.silinde87.gameaffinity.backend.domain.Producer;

import java.util.*;

public interface ProducerRepository extends CrudRepository<Producer, Long> {

    Optional<Producer> findByName(String name);
}

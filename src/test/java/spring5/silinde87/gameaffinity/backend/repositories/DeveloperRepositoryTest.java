package spring5.silinde87.gameaffinity.backend.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import spring5.silinde87.gameaffinity.backend.domain.Developer;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class DeveloperRepositoryTest {

    @Autowired
    DeveloperRepository developerRepository;

    @Test
    void findByName() {

        //Asking the repository to look up by "Atlus" dev.
        Optional<Developer>  atlusOptional = developerRepository.findByName("Atlus");
        assertEquals("Atlus", atlusOptional.get().getName());
    }
}
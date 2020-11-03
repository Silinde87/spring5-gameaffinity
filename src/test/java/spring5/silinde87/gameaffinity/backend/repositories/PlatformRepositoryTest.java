package spring5.silinde87.gameaffinity.backend.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import spring5.silinde87.gameaffinity.backend.domain.Platform;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlatformRepositoryTest {

    @Autowired
    PlatformRepository platformRepository;

    @Test
    void findByName() {

        //Asking the repository to look up by "Wii" dev.
        Optional<Platform>  wiiOptional = platformRepository.findByName("Wii");
        assertEquals("Wii", wiiOptional.get().getName());
    }

    @Test
    void findByBrand() {

        //Asking the repository to look up by "Microsoft" brand at platform table
        List<Platform> microsoftOptional = platformRepository.findByBrand("Microsoft");

        assertEquals(2, microsoftOptional.size());
    }
}
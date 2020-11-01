package spring5.silinde87.gameaffinity.backend.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring5.silinde87.gameaffinity.backend.domain.*;
import spring5.silinde87.gameaffinity.backend.repositories.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Component
@Profile("dev")
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final GenreRepository genreRepository;
    private final PlatformRepository platformRepository;
    private final DeveloperRepository developerRepository;
    private final ProducerRepository producerRepository;
    private final GameRepository gameRepository;

    public DataBootstrap(GenreRepository genreRepository, PlatformRepository platformRepository,
                         DeveloperRepository developerRepository, ProducerRepository producerRepository,
                         GameRepository gameRepository) {
        this.genreRepository = genreRepository;
        this.platformRepository = platformRepository;
        this.developerRepository = developerRepository;
        this.producerRepository = producerRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(gameRepository.count() == 0L) {
            gameRepository.saveAll(getGames());
            log.info("################### DATA LOADED ###################");
        }
    }

    private List<Game> getGames() {

        List<Game> games = new ArrayList<>();

        //Get Genres and Optionals
        Optional<Genre> actionOptional = genreRepository.findByName("Action");
        Optional<Genre> adventureOptional = genreRepository.findByName("Adventure");
        Optional<Genre> rpgOptional = genreRepository.findByName("Role-Playing");
        Optional<Genre> simulationOptional = genreRepository.findByName("Simulation");
        Optional<Genre> sportsOptional = genreRepository.findByName("Sports");
        Genre actionGenre = actionOptional.get();
        Genre adventureGenre = adventureOptional.get();
        Genre rpgGenre = rpgOptional.get();
        Genre simulationGenre = simulationOptional.get();
        Genre sportsGenre = sportsOptional.get();

        //Get Platforms and Optionals
        Optional<Platform> xbox360Optional = platformRepository.findByName("Xbox 360");
        Optional<Platform> ps3Optional = platformRepository.findByName("PlayStation 3");
        Optional<Platform> wiiOptional = platformRepository.findByName("Wii");
        Optional<Platform> xoneOptional = platformRepository.findByName("Xbox One");
        Optional<Platform> ps4Optional = platformRepository.findByName("PlayStation 4");
        Optional<Platform> wiiuOptional = platformRepository.findByName("Wii U");
        Platform xbox360Platform = xbox360Optional.get();
        Platform ps3Platform = ps3Optional.get();
        Platform wiiPlatform = wiiOptional.get();
        Platform xonePlatform = xoneOptional.get();
        Platform ps4Platform = ps4Optional.get();
        Platform wiiuPlatform = wiiuOptional.get();

        //Get Developers and Optionals
        Optional<Developer> atlusOptional = developerRepository.findByName("Atlus");
        Optional<Developer> bizarreOptional = developerRepository.findByName("Bizarre Creations");
        Optional<Developer> blizzardOptional = developerRepository.findByName("Blizzard Entertainment");
        Optional<Developer> bungieOptional = developerRepository.findByName("Bungie");
        Optional<Developer> epicOptional = developerRepository.findByName("Epic Games");
        Developer atlusDeveloper = atlusOptional.get();
        Developer bizarreDeveloper = bizarreOptional.get();
        Developer blizzardDeveloper = blizzardOptional.get();
        Developer bungieDeveloper = bungieOptional.get();
        Developer epicDeveloper = epicOptional.get();

        //Get Producers and Optionals
        Optional<Producer> eijiOptional = producerRepository.findByName("Eiji Aonuma");
        Optional<Producer> hideoOptional = producerRepository.findByName("Hideo Kojima");
        Optional<Producer> jonathanOptional = producerRepository.findByName("Jonathan Blow");
        Optional<Producer> gabeOptional = producerRepository.findByName("Gabe Newell");
        Optional<Producer> yujiOptional = producerRepository.findByName("Yuji Naka");
        Producer eijiProducer = eijiOptional.get();
        Producer hideoProducer = hideoOptional.get();
        Producer jonathanProducer = jonathanOptional.get();
        Producer gabeProducer = gabeOptional.get();
        Producer yujiProducer = yujiOptional.get();


        //Creating Mario game
        Game mario = Game.builder().name("Mario").releaseDate(LocalDate.of(2015,10,25))
                .developer(atlusDeveloper)
                .producer(eijiProducer)
                .genre(actionGenre)
                .platform(xbox360Platform)
                .build();

        atlusDeveloper.getGameList().add(mario);
        eijiProducer.getGameList().add(mario);
        actionGenre.getGameList().add(mario);
        xbox360Platform.getGameList().add(mario);

        games.add(mario);

        //Creating Gears of War game
        Game gow = Game.builder().name("Gears of War").releaseDate(LocalDate.of(2010,5,20))
                .developer(bizarreDeveloper)
                .producer(hideoProducer)
                .genre(adventureGenre)
                .platform(ps3Platform)
                .build();

        atlusDeveloper.getGameList().add(gow);
        eijiProducer.getGameList().add(gow);
        actionGenre.getGameList().add(gow);
        xbox360Platform.getGameList().add(gow);

        games.add(gow);

        log.info(games.size() + " Games saved.");

        //Creating Gears of War game
        Game halo = Game.builder().name("Halo 3").releaseDate(LocalDate.of(1977,6,18))
                .developer(blizzardDeveloper)
                .producer(jonathanProducer)
                .genre(rpgGenre)
                .platform(wiiPlatform)
                .build();

        atlusDeveloper.getGameList().add(halo);
        eijiProducer.getGameList().add(halo);
        actionGenre.getGameList().add(halo);
        xbox360Platform.getGameList().add(halo);

        games.add(halo);

        log.info(games.size() + " Games saved.");

        return games;
    }
}

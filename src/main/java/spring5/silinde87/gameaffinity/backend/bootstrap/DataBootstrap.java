package spring5.silinde87.gameaffinity.backend.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring5.silinde87.gameaffinity.backend.domain.*;
import spring5.silinde87.gameaffinity.backend.repositories.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final DeveloperRepository developerRepository;
    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;
    private final PlatformRepository platformRepository;
    private final ProducerRepository producerRepository;

    public DataBootstrap(DeveloperRepository developerRepository, GameRepository gameRepository,
                         GenreRepository genreRepository, PlatformRepository platformRepository,
                         ProducerRepository producerRepository) {
        this.developerRepository = developerRepository;
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
        this.platformRepository = platformRepository;
        this.producerRepository = producerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("################### LOADING DATA ###################");
        if(developerRepository.count() == 0)
            loadDevelopers();

        if(gameRepository.count() == 0)
            loadGames();

        if(genreRepository.count() == 0)
            loadGenres();

        if(platformRepository.count() == 0)
            loadPlatforms();

        if(producerRepository.count() == 0)
            loadProducers();
    }

    private void loadDevelopers() {
        Developer atlus = Developer.builder().name("Atlus").build();
        Developer bizarre = Developer.builder().name("Bizarre Creations").build();
        Developer blizzard = Developer.builder().name("Blizzard Entertainment").build();
        Developer bungie = Developer.builder().name("Bungie").build();
        Developer epic = Developer.builder().name("Epic Games").build();

        developerRepository.save(atlus);
        developerRepository.save(bizarre);
        developerRepository.save(blizzard);
        developerRepository.save(bungie);
        developerRepository.save(epic);

        log.info(developerRepository.count() + " Developers saved.");
    }

    private void loadGames() {
        Game mario = Game.builder().name("Mario").releaseDate(LocalDate.of(2015,10,25)).build();
        Game godOfWar = Game.builder().name("God of War").releaseDate(LocalDate.of(2018,12,20)).build();
        Game halo = Game.builder().name("Halo").releaseDate(LocalDate.of(2017,9,10)).build();
        Game zelda = Game.builder().name("Zelda").releaseDate(LocalDate.of(2013,4,1)).build();
        Game forza = Game.builder().name("Forza Horizon").releaseDate(LocalDate.of(2020,6,3)).build();

        gameRepository.save(mario);
        gameRepository.save(godOfWar);
        gameRepository.save(halo);
        gameRepository.save(zelda);
        gameRepository.save(forza);

        log.info(gameRepository.count() + " Games saved.");

    }

    private void loadGenres() {
        Genre action = Genre.builder().name("Action").build();
        Genre adventure = Genre.builder().name("Adventure").build();
        Genre rpg = Genre.builder().name("Role-Playing").build();
        Genre simulation = Genre.builder().name("Simulation").build();
        Genre sports = Genre.builder().name("Sports").build();

        genreRepository.save(action);
        genreRepository.save(adventure);
        genreRepository.save(rpg);
        genreRepository.save(simulation);
        genreRepository.save(sports);

        log.info(genreRepository.count() + " Genres saved.");
    }

    private void loadPlatforms() {
        Platform xbox360 = Platform.builder().name("Xbox 360").brand("Microsoft").build();
        Platform ps3 = Platform.builder().name("PlayStation 3").brand("Sony").build();
        Platform wii = Platform.builder().name("Wii").brand("Nintendo").build();
        Platform xboxOne = Platform.builder().name("Xbox One").brand("Microsoft").build();
        Platform ps4 = Platform.builder().name("PlayStation 4").brand("Sony").build();
        Platform wiiu = Platform.builder().name("Wii U").brand("Nintendo").build();

        platformRepository.save(xbox360);
        platformRepository.save(ps3);
        platformRepository.save(wii);
        platformRepository.save(xboxOne);
        platformRepository.save(ps4);
        platformRepository.save(wiiu);

        log.info(platformRepository.count() + " Platforms saved.");
    }

    private void loadProducers() {
        Producer eijiAonuma = Producer.builder().name("Eiji Aonuma").build();
        Producer hideoKojima = Producer.builder().name("Hideo Kojima").build();
        Producer jonathanBlow = Producer.builder().name("Jonathan Blow").build();
        Producer gabeNewell = Producer.builder().name("Gabe Newell").build();
        Producer yujiNaka = Producer.builder().name("Yuji Naka").build();

        producerRepository.save(eijiAonuma);
        producerRepository.save(hideoKojima);
        producerRepository.save(jonathanBlow);
        producerRepository.save(gabeNewell);
        producerRepository.save(yujiNaka);

        log.info(producerRepository.count() + " Producers saved.");
    }

}

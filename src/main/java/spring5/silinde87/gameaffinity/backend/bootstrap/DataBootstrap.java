package spring5.silinde87.gameaffinity.backend.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring5.silinde87.gameaffinity.backend.domain.*;
import spring5.silinde87.gameaffinity.backend.repositories.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
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
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("################### LOADING DATA ###################");
        if(genreRepository.count() == 0)
            loadGenres();

        if(platformRepository.count() == 0)
            loadPlatforms();

        if(developerRepository.count() == 0)
            loadDevelopers();

        if(producerRepository.count() == 0)
            loadProducers();

        if(gameRepository.count() == 0)
            loadGames();
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



    private void loadGames() {

        //Creating Mario game
        Game mario = Game.builder().name("Mario").releaseDate(LocalDate.of(2015,10,25))
                .developer(developerRepository.findAll().get(0))
                .producer(producerRepository.findAll().get(0))
                .genre(genreRepository.findAll().get(0))
                .platform(platformRepository.findAll().get(0))
                .build();

        developerRepository.findAll().get(0).getGameList().add(mario);
        producerRepository.findAll().get(0).getGameList().add(mario);
        genreRepository.findAll().get(0).getGameList().add(mario);
        platformRepository.findAll().get(0).getGameList().add(mario);

        Game godOfWar = Game.builder().name("God of War").releaseDate(LocalDate.of(2018,12,20))
                .developer(developerRepository.findAll().get(1))
                .producer(producerRepository.findAll().get(1))
                .genre(genreRepository.findAll().get(1))
                .platform(platformRepository.findAll().get(1))
                .build();

        developerRepository.findAll().get(1).getGameList().add(godOfWar);
        producerRepository.findAll().get(1).getGameList().add(godOfWar);
        genreRepository.findAll().get(1).getGameList().add(godOfWar);
        platformRepository.findAll().get(1).getGameList().add(godOfWar);

        Game halo = Game.builder().name("Halo").releaseDate(LocalDate.of(2017,9,10))
                .developer(developerRepository.findAll().get(2))
                .producer(producerRepository.findAll().get(2))
                .genre(genreRepository.findAll().get(2))
                .platform(platformRepository.findAll().get(2))
                .build();

        developerRepository.findAll().get(2).getGameList().add(halo);
        producerRepository.findAll().get(2).getGameList().add(halo);
        genreRepository.findAll().get(2).getGameList().add(halo);
        platformRepository.findAll().get(2).getGameList().add(halo);

        Game zelda = Game.builder().name("Zelda").releaseDate(LocalDate.of(2013,4,1))
                .developer(developerRepository.findAll().get(3))
                .producer(producerRepository.findAll().get(3))
                .genre(genreRepository.findAll().get(3))
                .platform(platformRepository.findAll().get(3))
                .build();

        developerRepository.findAll().get(3).getGameList().add(zelda);
        producerRepository.findAll().get(3).getGameList().add(zelda);
        genreRepository.findAll().get(3).getGameList().add(zelda);
        platformRepository.findAll().get(3).getGameList().add(zelda);

        Game forza = Game.builder().name("Forza Horizon").releaseDate(LocalDate.of(2020,6,3))
                .developer(developerRepository.findAll().get(4))
                .producer(producerRepository.findAll().get(4))
                .genre(genreRepository.findAll().get(4))
                .platform(platformRepository.findAll().get(4))
                .build();

        developerRepository.findAll().get(4).getGameList().add(forza);
        producerRepository.findAll().get(4).getGameList().add(forza);
        genreRepository.findAll().get(4).getGameList().add(forza);
        platformRepository.findAll().get(4).getGameList().add(forza);

        gameRepository.save(mario);
        gameRepository.save(godOfWar);
        gameRepository.save(halo);
        gameRepository.save(zelda);
        gameRepository.save(forza);

        log.info(gameRepository.count() + " Games saved.");

    }





}

package spring5.silinde87.gameaffinity.backend.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring5.silinde87.gameaffinity.backend.domain.*;
import spring5.silinde87.gameaffinity.backend.repositories.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Game mario = Game.builder().name("Mario").releaseDate(LocalDate.of(2015,10,25))
                .developer(developerRepository.findAll().get(0))
                .producer(producerRepository.findAll().get(0))
                .genre(genreRepository.findAll().get(0))
                .platform(platformRepository.findAll().get(0))
                .build();

        Set<Game> list1 = new HashSet<>();
        list1.add(mario);
        developerRepository.findAll().get(0).setGameList(list1);
        producerRepository.findAll().get(0).setGameList(list1);
        genreRepository.findAll().get(0).setGameList(list1);
        platformRepository.findAll().get(0).setGameList(list1);

        Game godOfWar = Game.builder().name("God of War").releaseDate(LocalDate.of(2018,12,20))
                .developer(developerRepository.findAll().get(1))
                .producer(producerRepository.findAll().get(1))
                .genre(genreRepository.findAll().get(1))
                .platform(platformRepository.findAll().get(1))
                .build();

        Set<Game> list2 = new HashSet<>();
        list1.add(godOfWar);
        developerRepository.findAll().get(1).setGameList(list2);
        producerRepository.findAll().get(1).setGameList(list2);
        genreRepository.findAll().get(1).setGameList(list2);
        platformRepository.findAll().get(1).setGameList(list2);

        Game halo = Game.builder().name("Halo").releaseDate(LocalDate.of(2017,9,10))
                .developer(developerRepository.findAll().get(2))
                .producer(producerRepository.findAll().get(2))
                .genre(genreRepository.findAll().get(2))
                .platform(platformRepository.findAll().get(2))
                .build();

        Set<Game> list3 = new HashSet<>();
        list1.add(halo);
        developerRepository.findAll().get(2).setGameList(list3);
        producerRepository.findAll().get(2).setGameList(list3);
        genreRepository.findAll().get(2).setGameList(list3);
        platformRepository.findAll().get(2).setGameList(list3);

        Game zelda = Game.builder().name("Zelda").releaseDate(LocalDate.of(2013,4,1))
                .developer(developerRepository.findAll().get(3))
                .producer(producerRepository.findAll().get(3))
                .genre(genreRepository.findAll().get(3))
                .platform(platformRepository.findAll().get(3))
                .build();

        Set<Game> list4 = new HashSet<>();
        list1.add(zelda);
        developerRepository.findAll().get(3).setGameList(list4);
        producerRepository.findAll().get(3).setGameList(list4);
        genreRepository.findAll().get(3).setGameList(list4);
        platformRepository.findAll().get(3).setGameList(list4);

        Game forza = Game.builder().name("Forza Horizon").releaseDate(LocalDate.of(2020,6,3))
                .developer(developerRepository.findAll().get(4))
                .producer(producerRepository.findAll().get(4))
                .genre(genreRepository.findAll().get(4))
                .platform(platformRepository.findAll().get(4))
                .build();

        Set<Game> list5 = new HashSet<>();
        list1.add(forza);
        developerRepository.findAll().get(4).setGameList(list5);
        producerRepository.findAll().get(4).setGameList(list5);
        genreRepository.findAll().get(4).setGameList(list5);
        platformRepository.findAll().get(4).setGameList(list5);

        gameRepository.save(mario);
        gameRepository.save(godOfWar);
        gameRepository.save(halo);
        gameRepository.save(zelda);
        gameRepository.save(forza);

        log.info(gameRepository.count() + " Games saved.");

    }





}

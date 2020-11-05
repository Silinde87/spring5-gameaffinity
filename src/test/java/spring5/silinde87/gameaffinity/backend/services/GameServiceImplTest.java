package spring5.silinde87.gameaffinity.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

    private static final String GAME_NAME = "Mario";

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    GameServiceImpl gameService;

    Game returnGame;
    List<Game> returnGameList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        returnGame = Game.builder().id(1L).name(GAME_NAME).build();
        returnGameList.clear();
        returnGameList.add(Game.builder().id(1L).build());
        returnGameList.add(Game.builder().id(2L).build());
    }

    @Test
    void findAll() {
        when(gameRepository.findAll()).thenReturn(returnGameList);

        Set<Game> games = gameService.findAll();

        assertNotNull(games);
        assertEquals(2, games.size());
    }

    @Test
    void findByNameContainingIgnoreCase() {
        Set<Game> returnGames = new HashSet<>();
        returnGames.add(Game.builder().name("Mario").build());

        when(gameRepository.findByNameContainingIgnoreCase(anyString())).thenReturn(returnGames);

        Set<Game> games = gameService.findByNameContainingIgnoreCase(GAME_NAME);
        Set<Game> gameEmpty = gameService.findByNameContainingIgnoreCase("");

        assertNotNull(games);
        assertEquals(returnGames.size(), games.size());
        assertEquals(returnGames.iterator().next(), games.iterator().next());
        assertEquals(gameRepository.findAll().size(), gameEmpty.size());
    }

    @Test
    void add() {
        Game gameToSave = Game.builder().id(1L).build();

        when(gameRepository.save(any())).thenReturn(returnGame);

        Game savedGame = gameService.add(gameToSave);

        verify(gameRepository).save(any());
    }

    @Test
    void update() {
        Game gameToUpdate = Game.builder().id(1L).build();

        when(gameRepository.save(any())).thenReturn(returnGame);

        Game updatedGame = gameService.update(gameToUpdate);

        assertNotNull(updatedGame);

        verify(gameRepository).save(any());
    }

    @Test
    void delete() {
        gameService.delete(returnGame);

        verify(gameRepository, times(1)).delete(any());
    }
}
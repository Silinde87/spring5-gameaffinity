package spring5.silinde87.gameaffinity.backend.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.services.GameServiceImpl;

import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameRepositoryTest {

    public static final String GAME_NAME = "Mario";

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    GameServiceImpl service;

    Game returnGame;

    @BeforeEach
    void setUp() {
        returnGame = Game.builder().id(1L).name(GAME_NAME).releaseDate(LocalDate.now()).build();

    }

    @Test
    void findByNameContainingIgnoreCase() {
        Set<Game> returnGames = new HashSet<>();
        returnGames.add(Game.builder().name("Mario").build());

        when(gameRepository.findByNameContainingIgnoreCase(any())).thenReturn(returnGames);

        Set<Game> game = service.findByNameContainingIgnoreCase(GAME_NAME);

        assertEquals(GAME_NAME, game.iterator().next().getName());

        verify(gameRepository).findByNameContainingIgnoreCase(any());
    }


}
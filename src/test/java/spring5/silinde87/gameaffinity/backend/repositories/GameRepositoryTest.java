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

    List<Game> listGame;

    @BeforeEach
    void setUp() {
        listGame = new ArrayList<>();
        listGame.add(Game.builder().id(1L).name(GAME_NAME).releaseDate(LocalDate.now()).build());
        listGame.add(Game.builder().id(2L).name(GAME_NAME).releaseDate(LocalDate.now()).build());
    }

    @Test
    void findByName() {

        when(gameRepository.findByName(any())).thenReturn(listGame);

        List<Game> marioList = service.findByName(GAME_NAME);

        assertEquals(GAME_NAME, marioList.get(0).getName());
        assertEquals(2, marioList.size());

        verify(gameRepository).findByName(any());
    }


}
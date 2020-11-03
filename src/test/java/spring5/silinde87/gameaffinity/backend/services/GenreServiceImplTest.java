package spring5.silinde87.gameaffinity.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring5.silinde87.gameaffinity.backend.domain.Genre;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;
import spring5.silinde87.gameaffinity.backend.repositories.GenreRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceImplTest {

    @Mock
    GenreRepository genreRepository;

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    GenreServiceImpl genreService;

    Genre returnGenre;

    @BeforeEach
    void setUp() {
        returnGenre = Genre.builder().id(1L).build();
    }

    @Test
    void findAll() {
        List<Genre> returnGenreList = new ArrayList<>();
        returnGenreList.add(Genre.builder().id(1L).build());
        returnGenreList.add(Genre.builder().id(2L).build());

        when(genreRepository.findAll()).thenReturn(returnGenreList);

        Collection<Genre> genres = genreService.findAll();

        assertNotNull(genres);
        assertEquals(2, genres.size());
    }

    @Test
    void add() {
        Genre genreToSave = Genre.builder().id(1L).build();

        when(genreRepository.save(any())).thenReturn(returnGenre);

        Genre savedGenre = genreService.add(genreToSave);

        assertNotNull(savedGenre);

        verify(genreRepository).save(any());
    }

    @Test
    void update() {
        Genre genreToUpdate = Genre.builder().id(1L).build();

        when(genreRepository.save(any())).thenReturn(returnGenre);

        Genre updatedGenre = genreService.update(genreToUpdate);

        assertNotNull(updatedGenre);

        verify(genreRepository).save(any());
    }

    @Test
    void delete() {
        genreService.delete(returnGenre);

        verify(genreRepository, times(1)).delete(any());
    }
}
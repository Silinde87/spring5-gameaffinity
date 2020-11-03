package spring5.silinde87.gameaffinity.backend.services;

import org.springframework.stereotype.Service;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.domain.Genre;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;
import spring5.silinde87.gameaffinity.backend.repositories.GenreRepository;

import java.util.*;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GameRepository gameRepository;

    public GenreServiceImpl(GenreRepository genreRepository, GameRepository gameRepository) {
        this.genreRepository = genreRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<Genre> findAll() {
        Set<Genre> genreSet = new HashSet<>();
        genreRepository.findAll().iterator().forEachRemaining(genreSet::add);
        return genreSet;
    }

    @Override
    public Genre add(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        for(Game game : gameRepository.findAll()){
            if(game.getGenre().getName().equals(genre.getName())){
                game.setGenre(null);
                gameRepository.save(game);
            }
        }
        genreRepository.delete(genre);
    }
}

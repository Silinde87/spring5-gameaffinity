package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.domain.Genre;
import spring5.silinde87.gameaffinity.backend.services.GameServiceImpl;
import spring5.silinde87.gameaffinity.backend.services.GenreServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

import java.util.*;
import java.util.stream.Collectors;

@Route(value = "genres", layout = MainView.class)
@PageTitle("Genres List")
public class GenreCrudView extends HorizontalLayout {

    private GenreServiceImpl genreService;
    private GameServiceImpl gameService;

    public GenreCrudView(GenreServiceImpl genreService, GameServiceImpl gameService){
        this.genreService = genreService;
        this.gameService = gameService;

        GridCrud<Genre> crud = new GridCrud<>(Genre.class, genreService);

        //Grid Configuration
        crud.getGrid().setColumns("name");
        crud.getGrid().addColumn(genre -> {
            Set<Game> game = genre.getGameList();
            return game.size() == 0 ? "-" : game.stream().map(Game::getName).collect(Collectors.joining(", "));
        }).setHeader("Game List");
        crud.getGrid().getColumns().forEach(col -> col.setAutoWidth(true).setSortable(true));

        //Form Configuration
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.getCrudFormFactory().setVisibleProperties("name", "gameList");

        //Layout Configuration
        add(crud);
        setSizeFull();

        //Logic Configuration
        crud.setOperations(
                () -> genreService.findAll(),
                genre -> genreService.add(genre),
                genre -> genreService.update(genre),
                genre -> genreService.delete(genre)
        );
    }

}

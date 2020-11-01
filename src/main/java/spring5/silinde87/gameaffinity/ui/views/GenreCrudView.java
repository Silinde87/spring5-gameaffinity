package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.CheckBoxGroupProvider;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.domain.Genre;
import spring5.silinde87.gameaffinity.backend.services.GameServiceImpl;
import spring5.silinde87.gameaffinity.backend.services.GenreServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

import java.util.HashSet;
import java.util.Set;
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
            return game == null ? "-" : game.stream().map(Game::getName).collect(Collectors.joining(", "));
        }).setHeader("Game List");

        //Form Configuration
        crud.getCrudFormFactory().setUseBeanValidation(false);
        crud.getCrudFormFactory().setVisibleProperties("name", "gameList");

        crud.getCrudFormFactory().setFieldProvider("gameList",
                new CheckBoxGroupProvider<>(gameService.findAll()));
        crud.getCrudFormFactory().setFieldProvider("gameList",
                new CheckBoxGroupProvider<>("Game List", gameService.findAll(), Game::getName));


        //Layout Configuration
        add(crud);
        //crud.setFindAllOperationVisible(false);
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

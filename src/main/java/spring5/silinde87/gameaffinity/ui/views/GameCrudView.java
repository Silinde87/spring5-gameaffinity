package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.CrudFormFactory;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;
import spring5.silinde87.gameaffinity.backend.domain.*;
import spring5.silinde87.gameaffinity.backend.services.*;
import spring5.silinde87.gameaffinity.ui.MainView;

@Route(value = "games", layout = MainView.class)
@PageTitle("Games List")
@RouteAlias(value = "", layout = MainView.class)
public class GameCrudView extends HorizontalLayout {

    public GameCrudView(GameServiceImpl gameService, DeveloperServiceImpl developerService,
                        ProducerServiceImpl producerService, GenreServiceImpl genreService,
                        PlatformServiceImpl platformService){

        //Crud Instance
        GridCrud<Game> crud = new GridCrud<>(Game.class);

        //Grid Configuration
        crud.getGrid().setColumns("name","developer", "producer", "genre", "platform", "releaseDate");
        crud.getGrid().getColumns().forEach(col -> col.setAutoWidth(true));

        //Form Configuration
        crud.getCrudFormFactory().setUseBeanValidation(false);
        crud.getCrudFormFactory().setVisibleProperties(
                "name","developer", "producer", "genre", "platform", "releaseDate");

        crud.getCrudFormFactory().setFieldProvider("developer",
                new ComboBoxProvider<>(developerService.findAll()));
        crud.getCrudFormFactory().setFieldProvider("developer",
                new ComboBoxProvider<>("Developer", developerService.findAll(),
                        new TextRenderer<>(Developer::getName), Developer::getName));

        crud.getCrudFormFactory().setFieldProvider("producer",
                new ComboBoxProvider<>(producerService.findAll()));
        crud.getCrudFormFactory().setFieldProvider("producer",
                new ComboBoxProvider<>("Producer", producerService.findAll(),
                        new TextRenderer<>(Producer::getName), Producer::getName));

        crud.getCrudFormFactory().setFieldProvider("genre",
                new ComboBoxProvider<>(genreService.findAll()));
        crud.getCrudFormFactory().setFieldProvider("genre",
                new ComboBoxProvider<>("Genres", genreService.findAll(),
                        new TextRenderer<>(Genre::getName), Genre::getName));

        crud.getCrudFormFactory().setFieldProvider("platform",
                new ComboBoxProvider<>(platformService.findAll()));
        crud.getCrudFormFactory().setFieldProvider("platform",
                new ComboBoxProvider<>("Platforms", platformService.findAll(),
                        new TextRenderer<>(Platform::getName), Platform::getName));


        //Layout Configuration
        add(crud);
        //crud.setFindAllOperationVisible(false);
        setSizeFull();

        //Logic Configuration
        crud.setOperations(
                () -> gameService.findAll(),
                game -> gameService.add(game),
                game -> gameService.update(game),
                game -> gameService.delete(game)
        );
    }
}

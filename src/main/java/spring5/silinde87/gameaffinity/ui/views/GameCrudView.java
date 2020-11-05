package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;
import spring5.silinde87.gameaffinity.backend.domain.*;
import spring5.silinde87.gameaffinity.backend.services.*;
import spring5.silinde87.gameaffinity.ui.MainView;

@Route(value = "games", layout = MainView.class)
@PageTitle("Games List")
@RouteAlias(value = "", layout = MainView.class)
public class  GameCrudView extends HorizontalLayout {

    public GameCrudView(GameServiceImpl gameService, DeveloperServiceImpl developerService,
                        ProducerServiceImpl producerService, GenreServiceImpl genreService,
                        PlatformServiceImpl platformService){

        //Crud Instance
        GridCrud<Game> crud = new GridCrud<>(Game.class, new HorizontalSplitCrudLayout());
        crud.setClickRowToUpdate(true);
        crud.setUpdateOperationVisible(false);

        //Additional components
        TextField filter = new TextField();
        filter.setPlaceholder("Filter by name");
        filter.setClearButtonVisible(true);
        crud.getCrudLayout().addFilterComponent(filter);

        //Grid Configuration
        crud.getGrid().setColumns("name", "developer", "producer", "genre", "platform", "releaseDate");
        crud.getGrid().getColumns().forEach(col -> col.setAutoWidth(true).setSortable(true));

        //Form Configuration
        crud.getCrudFormFactory().setUseBeanValidation(true);

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
        setSizeFull();
        add(crud);


        //Logic Configuration
        crud.setOperations(
                () -> gameService.findByNameContainingIgnoreCase(filter.getValue()),
                game -> gameService.add(game),
                game -> gameService.update(game),
                game -> gameService.delete(game)
        );

        filter.addValueChangeListener(e -> crud.refreshGrid());
    }
}

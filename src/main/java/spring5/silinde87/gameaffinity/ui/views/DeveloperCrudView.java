package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.services.DeveloperServiceImpl;
import spring5.silinde87.gameaffinity.backend.services.GameServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

import java.util.Set;
import java.util.stream.Collectors;

@Route(value = "developers", layout = MainView.class)
@PageTitle("Developers List")
public class DeveloperCrudView extends HorizontalLayout {

    private DeveloperServiceImpl developerService;
    private GameServiceImpl gameService;

    public DeveloperCrudView(DeveloperServiceImpl developerService, GameServiceImpl gameService) {
        this.developerService = developerService;
        this.gameService = gameService;

        GridCrud<Developer> crud = new GridCrud<>(Developer.class, developerService);

        //Grid Configuration
        crud.getGrid().setColumns("name");
        crud.getGrid().addColumn(developer -> {
            Set<Game> game = developer.getGameList();
            return game.size() == 0 ? "-" : game.stream().map(Game::getName).collect(Collectors.joining(", "));
        }).setHeader("Game List");
        crud.getGrid().getColumns().forEach(col -> col.setAutoWidth(true).setSortable(true));

        //Form Configuration
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.getCrudFormFactory().setVisibleProperties("name");

        //Layout Configuration
        add(crud);
        setSizeFull();

        //Logic Configuration
        crud.setOperations(
                () -> developerService.findAll(),
                developer -> developerService.add(developer),
                developer -> developerService.update(developer),
                developer -> developerService.delete(developer)
        );
    }
}

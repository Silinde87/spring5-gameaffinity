package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.domain.Platform;
import spring5.silinde87.gameaffinity.backend.services.GameServiceImpl;
import spring5.silinde87.gameaffinity.backend.services.PlatformServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

import java.util.Set;
import java.util.stream.Collectors;

@Route(value = "platforms", layout = MainView.class)
@PageTitle("Platforms List")
public class PlatformCrudView extends HorizontalLayout {

    private PlatformServiceImpl platformService;
    private GameServiceImpl gameService;

    public PlatformCrudView(PlatformServiceImpl platformService, GameServiceImpl gameService) {
        this.platformService = platformService;
        this.gameService = gameService;

        GridCrud<Platform> crud = new GridCrud<>(Platform.class, new HorizontalSplitCrudLayout());
        crud.setClickRowToUpdate(true);
        crud.setUpdateOperationVisible(false);

        //Grid Configuration
        crud.getGrid().setColumns("name", "brand");
        crud.getGrid().addColumn(platform -> {
            Set<Game> game = platform.getGameList();
            return game.size() == 0 ? "-" : game.stream().map(Game::getName).collect(Collectors.joining(", "));
        }).setHeader("Game List");
        crud.getGrid().getColumns().forEach(col -> col.setAutoWidth(true).setSortable(true));

        //Form Configuration
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.getCrudFormFactory().setVisibleProperties("name", "brand");

        //Layout Configuration
        add(crud);
        setSizeFull();

        //Logic Configuration
        crud.setOperations(
                () -> platformService.findAll(),
                platform -> platformService.add(platform),
                platform -> platformService.update(platform),
                platform -> platformService.delete(platform)
        );
    }
}

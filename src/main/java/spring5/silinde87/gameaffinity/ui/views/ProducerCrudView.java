package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.domain.Producer;
import spring5.silinde87.gameaffinity.backend.services.GameServiceImpl;
import spring5.silinde87.gameaffinity.backend.services.ProducerServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

import java.util.Set;
import java.util.stream.Collectors;

@Route(value = "producers", layout = MainView.class)
@PageTitle("Producers List")
public class ProducerCrudView extends HorizontalLayout {

    private ProducerServiceImpl producerService;
    private GameServiceImpl gameService;

    public ProducerCrudView(ProducerServiceImpl producerService, GameServiceImpl gameService) {
        this.producerService = producerService;
        this.gameService = gameService;

        GridCrud<Producer> crud = new GridCrud<>(Producer.class, producerService);

        //Grid Configuration
        crud.getGrid().setColumns("name");
        crud.getGrid().addColumn(producer -> {
            Set<Game> game = producer.getGameList();
            return game.size() == 0 ? "-" : game.stream().map(Game::getName).collect(Collectors.joining(", "));
        }).setHeader("Game List");
        crud.getGrid().getColumns().forEach(col -> col.setAutoWidth(true));

        //Form Configuration
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.getCrudFormFactory().setVisibleProperties("name");

        //Layout Configuration
        add(crud);
        setSizeFull();

        //Logic Configuration
        crud.setOperations(
                () -> producerService.findAll(),
                producer -> producerService.add(producer),
                producer -> producerService.update(producer),
                producer -> producerService.delete(producer)
        );
    }
}

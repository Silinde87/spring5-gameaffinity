package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.CrudFormFactory;
import spring5.silinde87.gameaffinity.backend.domain.Game;
import spring5.silinde87.gameaffinity.backend.services.GameServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

@Route(value = "games", layout = MainView.class)
@PageTitle("Games List")
@RouteAlias(value = "", layout = MainView.class)
public class GameCrudView extends HorizontalLayout {

    public GameCrudView(GameServiceImpl gameService){
        GridCrud<Game> crud = new GridCrud<>(Game.class,gameService);
        add(crud);


        setSizeFull();
    }
}

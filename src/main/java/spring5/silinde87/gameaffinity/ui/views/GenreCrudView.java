package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import spring5.silinde87.gameaffinity.backend.domain.Genre;
import spring5.silinde87.gameaffinity.backend.services.GenreServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

@Route(value = "genres", layout = MainView.class)
@PageTitle("Genres List")
public class GenreCrudView extends HorizontalLayout {

    public GenreCrudView(GenreServiceImpl genreService){
        GridCrud<Genre> crud = new GridCrud<>(Genre.class,genreService);
        add(crud);
        setSizeFull();
    }
}

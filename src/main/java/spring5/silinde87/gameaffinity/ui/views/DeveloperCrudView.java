package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.services.DeveloperServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

@Route(value = "developers", layout = MainView.class)
@PageTitle("Developers List")
public class DeveloperCrudView extends HorizontalLayout {

    public DeveloperCrudView(DeveloperServiceImpl developerService){
        GridCrud<Developer> crud = new GridCrud<>(Developer.class,developerService);
        add(crud);
        setSizeFull();
    }
}

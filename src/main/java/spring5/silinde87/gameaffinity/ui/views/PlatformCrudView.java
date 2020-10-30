package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import spring5.silinde87.gameaffinity.backend.domain.Platform;
import spring5.silinde87.gameaffinity.backend.services.PlatformServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

@Route(value = "platforms", layout = MainView.class)
@PageTitle("Platforms List")
public class PlatformCrudView extends HorizontalLayout {

    public PlatformCrudView(PlatformServiceImpl platformService){
        GridCrud<Platform> crud = new GridCrud<>(Platform.class,platformService);
        add(crud);
        setSizeFull();
    }
}

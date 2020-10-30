package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import spring5.silinde87.gameaffinity.backend.domain.Producer;
import spring5.silinde87.gameaffinity.backend.services.ProducerServiceImpl;
import spring5.silinde87.gameaffinity.ui.MainView;

@Route(value = "producers", layout = MainView.class)
@PageTitle("Producers List")
public class ProducerCrudView extends HorizontalLayout {

    public ProducerCrudView(ProducerServiceImpl producerService){
        GridCrud<Producer> crud = new GridCrud<>(Producer.class,producerService);
        add(crud);
        setSizeFull();
    }
}

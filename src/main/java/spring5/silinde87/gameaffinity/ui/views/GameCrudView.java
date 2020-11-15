package spring5.silinde87.gameaffinity.ui.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
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
public class  GameCrudView extends Composite<HorizontalLayout> implements HasComponents {

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

        //Show description and image
        crud.getGrid().setItemDetailsRenderer(new ComponentRenderer<>(game -> {
            if(game.getDescription() == null || game.getImageUrl() == null){
                Label notFoundLabel = new Label("There is no description or image.");
                notFoundLabel.getStyle().set("alignSelf", "center");
                HorizontalLayout labelLayout = new HorizontalLayout(notFoundLabel);
                labelLayout.setAlignItems(FlexComponent.Alignment.CENTER);
                return labelLayout;
            }else {
                Image frontImage = new Image();
                frontImage.setSrc(game.getImageUrl());
                frontImage.setWidth("192px");
                frontImage.setHeight("108px");
                Label descriptionLabel = new Label(game.getDescription());
                descriptionLabel.setHeight("200px");
                return new HorizontalLayout(frontImage, descriptionLabel);
            }
        }));

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
        getContent().setSizeFull();
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

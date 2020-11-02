package spring5.silinde87.gameaffinity.backend.services;

import org.vaadin.crudui.crud.CrudListener;
import spring5.silinde87.gameaffinity.backend.domain.Game;

import java.util.List;

public interface GameService extends CrudListener<Game> {

    List<Game> findByName(String name);
}

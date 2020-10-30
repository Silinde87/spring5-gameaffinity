package spring5.silinde87.gameaffinity.backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@Document
public class Producer {

    @Id
    private String id;

    @NotNull
    private String name;

    private Set<Game> gameList = new HashSet<>();
}

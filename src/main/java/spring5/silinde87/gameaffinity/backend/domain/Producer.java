package spring5.silinde87.gameaffinity.backend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@Builder
@Document
public class Producer {

    @Id
    private String id;

    @NotNull
    private String name;

    @DBRef
    private Set<Game> gameList;

    @Override
    public String toString() {
        return name;
    }
}

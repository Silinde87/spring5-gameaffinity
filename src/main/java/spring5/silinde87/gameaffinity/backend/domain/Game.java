package spring5.silinde87.gameaffinity.backend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;

@Data
@Builder
@Document
public class Game {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate releaseDate;

    @DBRef
    private Developer developer;

    @DBRef
    private Producer producer;

    @DBRef
    private Set<Genre> genres;

    @DBRef
    private Set<Platform> platforms;


}

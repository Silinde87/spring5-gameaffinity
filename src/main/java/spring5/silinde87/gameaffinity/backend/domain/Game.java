package spring5.silinde87.gameaffinity.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "games")
public class Game {

    @Id
    private String id;

    @NotNull
    private String name;

    @Past
    private LocalDate releaseDate;

    @NotNull
    @DBRef
    private Developer developer;

    @NotNull
    @DBRef
    private Producer producer;

    @NotNull
    @DBRef
    private Genre genre;

    @NotNull
    @DBRef
    private Platform platform;


}

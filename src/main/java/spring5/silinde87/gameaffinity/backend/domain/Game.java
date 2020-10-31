package spring5.silinde87.gameaffinity.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Game {

    @Id
    private String id;

    @NotNull
    private String name;

    @Past
    private LocalDate releaseDate;

    @NotNull
    private Developer developer;

    @NotNull
    private Producer producer;

    @NotNull
    private Genre genre;

    @NotNull
    private Platform platform;


}

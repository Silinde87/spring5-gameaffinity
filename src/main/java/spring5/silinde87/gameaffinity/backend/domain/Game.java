package spring5.silinde87.gameaffinity.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import java.time.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Past
    private LocalDate releaseDate;

    @NotNull
    @ManyToOne
    private Developer developer;

    @NotNull
    @ManyToOne
    private Producer producer;

    @NotNull
    @ManyToOne
    private Genre genre;

    @NotNull
    @ManyToOne
    private Platform platform;


}

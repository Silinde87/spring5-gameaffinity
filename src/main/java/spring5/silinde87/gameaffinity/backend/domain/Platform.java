package spring5.silinde87.gameaffinity.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"gameList"})
@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String brand;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platform", fetch = FetchType.EAGER)
    private Set<Game> gameList = new HashSet<>();

    @Override
    public String toString() {
        return name;
    }
}

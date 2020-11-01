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
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producer", fetch = FetchType.EAGER)
    private Set<Game> gameList = new HashSet<>();

    @Override
    public String toString() {
        return name;
    }
}

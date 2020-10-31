package spring5.silinde87.gameaffinity.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Platform {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String brand;

    private Set<Game> gameList = new HashSet<>();

    @Override
    public String toString() {
        return name;
    }
}

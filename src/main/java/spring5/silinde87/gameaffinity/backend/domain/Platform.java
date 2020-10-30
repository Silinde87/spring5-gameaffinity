package spring5.silinde87.gameaffinity.backend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Document
public class Platform {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String brand;
}

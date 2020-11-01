package spring5.silinde87.gameaffinity.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genres")
public class Genre {

    @Id
    private String id;

    @NotNull
    private String name;

    @DBRef(lazy = true)
    private Set<Game> gameList = new HashSet<>();

    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return this.id;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public Set<Game> getGameList() {
        return this.gameList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setGameList(Set<Game> gameList) {
        this.gameList = gameList;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Genre)) return false;
        final Genre other = (Genre) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$gameList = this.getGameList();
        final Object other$gameList = other.getGameList();
        if (this$gameList == null ? other$gameList != null : !this$gameList.equals(other$gameList)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Genre;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $gameList = this.getGameList();
        result = result * PRIME + ($gameList == null ? 43 : $gameList.hashCode());
        return result;
    }
}

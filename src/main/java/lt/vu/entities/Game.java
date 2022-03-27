package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Game.findAll", query = "select a from Game as a")
})
@Table(name = "GAME")
@Getter @Setter
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Column(name = "Cost")
    private Integer cost;

    @ManyToOne
    @JoinColumn(name="GENRE_ID")
    private Genre genre;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Game() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

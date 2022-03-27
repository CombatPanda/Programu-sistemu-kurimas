package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Genre;
import lt.vu.persistence.GenresDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Genres {

    @Inject
    private GenresDAO genresDAO;

    @Getter @Setter
    private Genre genreToCreate = new Genre();

    @Getter
    private List<Genre> allGenres;

    @PostConstruct
    public void init(){
        loadAllGenres();
    }

    @Transactional
    public void createGenre(){
        this.genresDAO.persist(genreToCreate);
    }

    private void loadAllGenres(){
        this.allGenres = genresDAO.loadAll();
    }
}

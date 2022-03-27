package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.GenreMapper;
import lt.vu.mybatis.model.Genre;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class GenresMyBatis {
    @Inject
    private GenreMapper genreMapper;

    @Getter
    private List<Genre> allGenres;

    @Getter @Setter
    private Genre genreToCreate = new Genre();

    @PostConstruct
    public void init() {
        this.loadAllGenres();
    }

    private void loadAllGenres() {
        this.allGenres = genreMapper.selectAll();
    }

    @Transactional
    public String createGenre() {
        genreMapper.insert(genreToCreate);
        return "/myBatis/genres?faces-redirect=true";
    }
}

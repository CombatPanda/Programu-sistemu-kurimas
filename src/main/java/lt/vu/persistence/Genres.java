package lt.vu.persistence;

import lt.vu.mybatis.model.Genre;

import java.util.List;

public interface Genres {

    void persist(Genre genre);
    List<Genre> loadAll();
    Genre findOne(Integer id);
}

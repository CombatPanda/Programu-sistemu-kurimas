package lt.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Developer;
import lt.vu.entities.Genre;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.GenresDAO;
import lt.vu.entities.Game;

@Model
public class GamesForGenre implements Serializable {

    @Inject
    private GenresDAO genresDAO;

    @Inject
    private GamesDAO gamesDAO;

    @Getter @Setter
    private Genre genre;

    @Getter @Setter
    private Developer gameDeveloper = new Developer();

    @Getter @Setter
    private Game gameToCreate = new Game();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer genreId = Integer.parseInt(requestParameters.get("genreId"));
        this.genre = genresDAO.findOne(genreId);
    }

    @Transactional
    @LoggedInvocation
    public void createGame() {
        gameToCreate.setGenre(this.genre);
       //gameToCreate.getGameDevelopers().add(gameDeveloper);
        gamesDAO.persist(gameToCreate);
    }
}

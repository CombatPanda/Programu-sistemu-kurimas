package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Game;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.GamesDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateGameDetails implements Serializable {

    private Game game;

    @Inject
    private GamesDAO gamesDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateGameDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer gameId = Integer.parseInt(requestParameters.get("gameId"));
        this.game = gamesDAO.findOne(gameId);
    }

    @Transactional
    @LoggedInvocation
    public String updateGameCost() {
        try{
            gamesDAO.update(this.game);
        } catch (OptimisticLockException e) {
            return "/gameDetails.xhtml?faces-redirect=true&gameId=" + this.game.getId() + "&error=optimistic-lock-exception";
        }
        System.out.println("Updated: " + game.getName() + ", id: " + game.getId());
        return "games.xhtml?genreId=" + this.game.getGenre().getId() + "&faces-redirect=true";
    }
    @Transactional
    @LoggedInvocation
    public String updateGameDeveloper() {
        try{
            gamesDAO.update(this.game);
        } catch (OptimisticLockException e) {
            return "/gameDetails.xhtml?faces-redirect=true&gameId=" + this.game.getId() + "&error=optimistic-lock-exception";
        }
        return "games.xhtml?genreId=" + this.game.getGenre().getId() + "&faces-redirect=true";
    }
}

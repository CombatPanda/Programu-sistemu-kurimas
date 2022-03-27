package lt.vu.persistence;

import lt.vu.entities.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class GamesDAO {

    @Inject
    private EntityManager em;

    public void persist(Game game){
        this.em.persist(game);
    }

    public Game findOne(Integer id){
        return em.find(Game.class, id);
    }

    public Game update(Game game){
        return em.merge(game);
    }
}

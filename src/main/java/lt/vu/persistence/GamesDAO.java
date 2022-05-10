package lt.vu.persistence;

import lt.vu.entities.Game;
import lt.vu.interceptors.LogMethod;
import lt.vu.interceptors.LoggedInvocation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

@ApplicationScoped
@Alternative
public class GamesDAO implements Games{

    @Inject
    private EntityManager em;

    public void persist(Game game){
        this.em.persist(game);
    }

    public Game findOne(Integer id){
        return em.find(Game.class, id);
    }

    @LogMethod
    public Game update(Game game){
        return em.merge(game);
    }
}

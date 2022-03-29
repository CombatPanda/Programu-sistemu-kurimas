package lt.vu.persistence;

import lt.vu.entities.Developer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DevelopersDAO {

    @Inject
    private EntityManager em;

    public void persist(Developer developer){
        this.em.persist(developer);
    }

    public Developer findOne(Integer id){
        return em.find(Developer.class, id);
    }

    public Developer update(Developer developer){
        return em.merge(developer);
    }

    public List<Developer> loadAll() {
        return em.createNamedQuery("Developer.findAll", Developer.class).getResultList();
    }


}

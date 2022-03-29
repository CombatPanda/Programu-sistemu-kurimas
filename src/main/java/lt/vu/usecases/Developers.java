package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Developer;
import lt.vu.persistence.DevelopersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Developers {

    @Inject
    private DevelopersDAO developersDAO;

    @Getter @Setter
    private Developer developerToCreate = new Developer();

    @Getter
    private List<Developer> allDevelopers;

    @PostConstruct
    public void init(){
        loadAllDevelopers();
    }

    @Transactional
    public void createDeveloper(){
        this.developersDAO.persist(developerToCreate);
    }

    private void loadAllDevelopers(){
        this.allDevelopers = developersDAO.loadAll();
    }
}

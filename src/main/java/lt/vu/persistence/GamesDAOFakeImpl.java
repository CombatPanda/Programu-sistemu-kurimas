package lt.vu.persistence;

import lt.vu.entities.Game;

import javax.enterprise.inject.Alternative;

@Alternative
public class GamesDAOFakeImpl implements Games{


    @Override
    public void persist(Game gameToCreate) {
        System.out.println("does nothing");
    }
}

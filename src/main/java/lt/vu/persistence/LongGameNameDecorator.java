package lt.vu.persistence;

import lt.vu.entities.Game;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;


@Decorator
public abstract class LongGameNameDecorator implements Games {

    @Inject
    @Delegate
    @Any
    Games games;

    public void persist(Game gameToCreate){
        games.persist(gameToCreate);

        if(gameToCreate.getName().length() > 15){
            System.out.println("Game with a very long name has been created: " + gameToCreate.getName());
        }
    }
}

package lt.vu.persistence;

import lt.vu.entities.Game;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;

@Specializes
public class LogGamesDAO extends GamesDAO{

    @Override
    public void persist(Game game) {
        super.persist(game);
        System.out.println("Persisted: " + game.getName() + ", id: " + game.getId());
    }

    @Override
    public Game update(Game game){
        Game result = super.update(game);
        System.out.println("Updated: " + result.getName() + ", id: " + result.getId());
        return result;
    }
}

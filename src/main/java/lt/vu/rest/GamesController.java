package lt.vu.rest;

import lombok.*;
import lt.vu.rest.contracts.GameDto;
import lt.vu.entities.Game;
import lt.vu.persistence.GamesDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/games")
public class GamesController {

    @Inject
    @Setter @Getter
    private GamesDAO gamesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Game game = gamesDAO.findOne(id);
        if (game == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        GameDto gameDto = new GameDto();
        gameDto.setName(game.getName());
        gameDto.setCost(game.getCost());
        gameDto.setGenreName(game.getGenre().getName());

        return Response.ok(gameDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer gameId,
            GameDto gameData) {
        try {
            Game existingGame = gamesDAO.findOne(gameId);
            if (existingGame == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingGame.setName(gameData.getName());
            existingGame.setCost(gameData.getCost());
            gamesDAO.update(existingGame);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}

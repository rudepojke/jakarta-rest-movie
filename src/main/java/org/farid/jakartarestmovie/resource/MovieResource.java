package org.farid.jakartarestmovie.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.farid.jakartarestmovie.model.Movie;
import org.farid.jakartarestmovie.repository.MovieRepository;

import java.util.List;
/**
 * expenerar endpointer för crud operationer på /movies
 */
@Path("/movies")
/**
 * svarar med json
 */
@Produces(MediaType.APPLICATION_JSON)
/**
 * tar in data med json
 */
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {

    /**
     *repo som hanterar dataoperationer för movies
     * injiceras av CDI
     */
    @Inject
    private MovieRepository repo;

    /**
     * Skapar en ny film
     */
    @POST
    @Transactional
    public Response create(Movie movie) {
        repo.create(movie);
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * hämtar alla filmer
     */
    @GET
    public List<Movie> getAll() {
        return repo.findAll();
    }

    /**
     * hämtar en film med specifik id
     */
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        Movie movie = repo.find(id);
        if (movie == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(movie).build();
    }

    /**
     * ändrar eller uppdaterar en specifik film
     */
    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Movie movie) {
        Movie existing = repo.find(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();

        existing.setTitle(movie.getTitle());
        existing.setGenre(movie.getGenre());
        existing.setReleaseYear(movie.getReleaseYear());
        existing.setDescription(movie.getDescription());
        existing.setDirector(movie.getDirector());

        repo.update(existing);
        return Response.ok(existing).build();
    }

    /**
     * tar bort en film med specifik id
     */
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Movie existing = repo.find(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();
        repo.delete(id);
        return Response.noContent().build();
    }
}

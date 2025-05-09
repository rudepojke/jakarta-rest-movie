package org.farid.jakartarestmovie.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.farid.jakartarestmovie.model.Movie;
import java.util.List;

/**
 * hanterar alla data anrop för movie entiteten
 */
@ApplicationScoped
/**
 * Gör så att Varje metod körs i en JTA‐transaktion
 */
@Transactional
public class MovieRepository {
    /**
     * gör så att Entity managern infogas automatiskt av containern
     * vår entity manager som används för att kommunicera med databasen
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Skapar en ny film i databasen
     */
    public void create(Movie movie) {
        em.persist(movie);
    }

    /**
     * Hämtar en film med specifierad id
     */
    public Movie find(Long id) {
        return em.find(Movie.class, id);
    }

    /**
     * hämtar alla filmer
     */
    public List<Movie> findAll() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    /**
     * ändrar en film i databasen
     */
    public Movie update(Movie movie) {
        return em.merge(movie);
    }

    /**
     * Ta bort en film i databasen
     */
    public void delete(Long id) {
        Movie movie = find(id);
        if (movie != null) {
            em.remove(movie);
        }
    }
}


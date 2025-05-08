package org.farid.jakartarestmovie.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.farid.jakartarestmovie.model.Movie;
import java.util.List;

@ApplicationScoped
@Transactional
public class MovieRepository {
    @PersistenceContext
    private EntityManager em;

    public void create(Movie movie) {
        em.persist(movie);
    }

    public Movie find(Long id) {
        return em.find(Movie.class, id);
    }

    public List<Movie> findAll() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    public Movie update(Movie movie) {
        return em.merge(movie);
    }

    public void delete(Long id) {
        Movie movie = find(id);
        if (movie != null) {
            em.remove(movie);
        }
    }
}


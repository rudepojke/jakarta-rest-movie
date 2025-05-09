package org.farid.jakartarestmovie.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity gör klassen en tabel i databasen
 */
@Entity

/**
 * Movie-klassen som innehåller filmers attributes, konstruktör, getters och setters
 */
public class Movie {
    /**
     * Skapar premiärt nycklar som är auto-genererad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    /**
     * filmernas attributes
     */
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    private String description;
    private String director;

    /**
     * tom Konstruktör som krävs av JPA
     */
    public Movie() {}

    /**
     * Kontruktör för att skapa en film instans
     */
    public Movie(String title, String genre, int releaseYear, String description, String director) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.description = description;
        this.director = director;
    }

    /**
     *  getters och setters för alla attributes
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}


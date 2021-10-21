package org.movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie implements IEntity<Long>{

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    Long id;

    @Getter
    @Setter
    @Column(name = "movie_title", nullable = false)
    String title;

    @Getter
    @Setter
    @Column(name = "description")
    String description;

    @Getter
    @Setter
    @Column(name = "release_date")
    LocalDate releaseDate;

    @Getter
    @ManyToMany
    @JoinTable(
                name="movie_has_actor",
                joinColumns = @JoinColumn(name="movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    Set<Actor> actors = new HashSet<>();

    @Getter
    @ManyToMany
    @JoinTable(
            name = "movie_has_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    Set<Genre> genres = new HashSet<>();

    public Movie(String title) {
        this.title = title;
    }

    public Movie() {
    }

}

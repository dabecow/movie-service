package org.movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Genre implements IEntity<Long>{

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "genre_name", nullable = false, unique = true)
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}

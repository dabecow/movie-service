package org.movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Actor implements IEntity<Long>{

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "actor_name", nullable = false)
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public Actor() {
    }
}

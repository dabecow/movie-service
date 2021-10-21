package org.movies.model;

import java.io.Serializable;

public interface IEntity<PK extends Serializable> extends Serializable {
    PK getId();
    void setId(PK id);
}

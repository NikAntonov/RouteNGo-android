package hu.pe.routengo.entity;

import io.requery.Entity;


@Entity
public abstract class AbstractObjective {
    protected String type;
    protected int imageId;

    public AbstractObjective() {
    }

    public AbstractObjective(String type, int imageId) {
        this.type = type;
        this.imageId = imageId;
    }
}

package hu.pe.routengo.entity;

import io.requery.Entity;


@Entity
public abstract class AbstractInterest {
    protected String type;
    protected String name;
    protected int imageId;

    public AbstractInterest() {
    }

    public AbstractInterest(String type, String name, int imageId) {
        this.type = type;
        this.name = name;
        this.imageId = imageId;
    }
}

package hu.pe.routengo.entity;

import hu.pe.routengo.R;
import io.requery.Entity;


@Entity
public abstract class AbstractObjective {
    String name;
    int imageId = R.drawable.caption;
    int marked;

    public AbstractObjective() {
    }

    public AbstractObjective(String name) {
        this.name = name;
    }
}

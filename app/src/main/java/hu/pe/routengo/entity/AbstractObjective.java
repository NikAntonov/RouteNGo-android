package hu.pe.routengo.entity;

import hu.pe.routengo.R;
import io.requery.Entity;


@Entity
public abstract class AbstractObjective {
    protected String type;
    protected int imageId = R.drawable.caption;

    public AbstractObjective() {
    }

    public AbstractObjective(String type) {
        this.type = type;
    }
}

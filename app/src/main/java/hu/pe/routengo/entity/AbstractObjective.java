package hu.pe.routengo.entity;

import hu.pe.routengo.R;
import io.requery.Entity;

/**
 * Created by Galya Sheremetova on 19.02.2017.
 */

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

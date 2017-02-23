package hu.pe.routengo.entity;

import android.os.Parcelable;

import java.util.List;

import io.requery.Entity;
import io.requery.ManyToMany;

@Entity
public abstract class AbstractRoute implements Parcelable {
    protected String time = "52 min";
    protected String distance = "7.1 km";
    protected String places = "Lorem ipsum dolor sit amet";
    protected String type = "history";
    protected String name;
    protected String date;
    @ManyToMany
    protected List<Place> placeList;
}

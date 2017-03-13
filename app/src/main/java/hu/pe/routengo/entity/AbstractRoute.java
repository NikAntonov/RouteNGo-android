package hu.pe.routengo.entity;

import android.os.Parcelable;

import java.util.List;

import io.requery.Entity;
import io.requery.ManyToMany;

@Entity
public abstract class AbstractRoute implements Parcelable {
    protected String time;
    protected String distance;
    protected String type;
    protected String name;
    protected String date;
    protected String points;
    @ManyToMany
    protected List<Place> places;


}

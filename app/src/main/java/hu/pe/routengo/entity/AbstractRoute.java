package hu.pe.routengo.entity;

import com.google.android.gms.location.places.Place;

import java.util.ArrayList;

import io.requery.Entity;
import io.requery.ManyToMany;

@Entity
public abstract class AbstractRoute {
    public String time = "52 min";
    public String distance = "7.1 km";
    public String places = "Lorem ipsum dolor sit amet";
    public String type = "history";
    public String name;
    public String date;
    @ManyToMany
    public ArrayList<Place> placeList = new ArrayList<>();

}

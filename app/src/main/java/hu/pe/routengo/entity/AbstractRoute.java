package hu.pe.routengo.entity;

import com.google.android.gms.location.places.Place;

import java.util.ArrayList;
import java.util.List;

import io.requery.Entity;
import io.requery.ManyToMany;

@Entity
public abstract class AbstractRoute {
    String time = "52 min";
    String distance = "7.1 km";
    String places = "Lorem ipsum dolor sit amet";
    String type = "history";
    String name;
    String date;
    @ManyToMany
    List<Place> placeList = new ArrayList<>();

    public AbstractRoute() {
    }

    public AbstractRoute(String name, List<Place> placeList) {
        this.name = name;
        this.placeList = placeList;
    }
}

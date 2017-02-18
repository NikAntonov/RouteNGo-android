package hu.pe.routengo.entity;

import com.google.android.gms.location.places.Place;

import java.util.ArrayList;

import io.requery.Entity;

@Entity
public abstract class AbstractRoute {
    private String time = "52 min";
    private String distance = "7.1 km";
    private String places = "Lorem ipsum dolor sit amet";
    private String type = "history";
    private String name;
    private String date;
    private ArrayList<Place> objects = new ArrayList<Place>();

}

package hu.pe.routengo.model;

import java.util.List;

import hu.pe.routengo.entity.Place;
import io.reactivex.Observable;


/**
 * Created by Galya Sheremetova on 18.02.2017.
 */

public interface RouteNGoService {


    Observable<List<Place>> getPlaceList();
}

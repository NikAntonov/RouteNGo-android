package hu.pe.routengo.model;

import java.util.List;

import hu.pe.routengo.entity.Place;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RouteNGoService {

    @GET("places")
    Observable<List<Place>> getPlaceList();
}

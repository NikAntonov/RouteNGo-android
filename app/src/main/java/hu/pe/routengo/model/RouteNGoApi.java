package hu.pe.routengo.model;

import java.util.List;

import hu.pe.routengo.entity.Place;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RouteNGoApi {

    @GET("places")
    Observable<List<Place>> getFullPlaceList();

    @GET("places/{type}")
    Observable<List<Place>> getPlaceList(@Path("type") String type);
}

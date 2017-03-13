package hu.pe.routengo.model;

import java.util.List;
import java.util.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by megaman on 13.03.2017.
 */

public interface GoogleMapsApi {
    @GET("/maps/api/directions/json")
    Observable getRoute(
            @Query("origin") String position,
            @Query("waypoints") List<String> wayPoints,
            @Query("destination") String destination,
            @Query("language") String language);
}

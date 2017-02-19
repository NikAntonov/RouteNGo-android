package hu.pe.routengo.model;

import java.util.List;

import hu.pe.routengo.entity.Place;
import hu.pe.routengo.entity.Route;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.requery.Persistable;
import io.requery.reactivex.ReactiveEntityStore;


/**
 * Created by Galya Sheremetova on 18.02.2017.
 */
//@Singleton
public class RouteNGoCache {
    private ReactiveEntityStore<Persistable> entityStore;

    //@Inject
    public RouteNGoCache(ReactiveEntityStore<Persistable> entityStore) {
        this.entityStore = entityStore;
    }

    public Completable deletePlaceList() {
        return entityStore.delete(Place.class).get().single().toCompletable();
    }


    public Single<Iterable<Place>> addPlaceList(List<Place> placeList) {
        return entityStore.insert(placeList);
    }

    public Single<Route> addRoute(Route route) {
        return entityStore.insert(route);
    }

    public Observable<List<Place>> getPlaceList() {
        return entityStore.select(Place.class).get().observable()
                .toList().toObservable();
    }

    public Observable<List<Route>> getRouteList() {
        return entityStore.select(Route.class)
                .orderBy(Route.TYPE).get().observable()
                .toList().toObservable();
    }
}

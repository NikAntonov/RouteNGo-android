package hu.pe.routengo.model;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.pe.routengo.entity.Interest;
import hu.pe.routengo.entity.Place;
import hu.pe.routengo.entity.Route;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.requery.Persistable;
import io.requery.reactivex.ReactiveEntityStore;



@Singleton
public class RouteNGoCache {
    private ReactiveEntityStore<Persistable> entityStore;

    @Inject
    public RouteNGoCache(ReactiveEntityStore<Persistable> entityStore) {
        this.entityStore = entityStore;
    }

    public Observable<List<Place>> setPlaceList(List<Place> placeList) {
        return entityStore.upsert(placeList).toObservable()
                .flatMap(Observable::fromIterable).toList().toObservable();
    }

    public Single<Route> addRoute(Route route) {
        return entityStore.insert(route);
    }

    public Observable<List<Place>> getPlaceList() {
        return entityStore.select(Place.class).get()
                .observable().toList().toObservable();
    }

    public Observable<List<Place>> getPlaceList(String type) {
        return entityStore.select(Place.class).where(Place.TYPE.eq(type)).get()
                .observable().toList().toObservable();
    }

    public Observable<List<Route>> getRouteList() {
        return entityStore.select(Route.class)
                .orderBy(Route.TYPE).get().observable()
                .toList().toObservable();
    }

    public Single<List<Interest>> getInterests() {
        return entityStore.select(Interest.class).get().observable().toList();
    }
}

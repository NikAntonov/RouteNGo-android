package hu.pe.routengo.model;

import java.util.List;

import hu.pe.routengo.entity.Place;
import io.reactivex.Observable;
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

    public Observable<List<Place>> getPlaceList() {
        return entityStore.select(Place.class).get().observable()
                .toList().toObservable();
    }

   /* public Observable<List<Place>> getRouteList() {
        return entityStore.select(Route.class).orderBy(Route.).get().observable()
                .toList().toObservable();
    }*/
}

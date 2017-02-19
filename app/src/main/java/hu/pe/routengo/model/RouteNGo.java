package hu.pe.routengo.model;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.pe.routengo.entity.Place;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Galya Sheremetova on 18.02.2017.
 */
@Singleton
public class RouteNGo {
    public static final String URL = "http://routengo.pe.hu/admin/api/";

    private RouteNGoService service;
    private RouteNGoCache cache;

    @Inject
    public RouteNGo(RouteNGoService service, RouteNGoCache cache) {
        this.service = service;
        this.cache = cache;
    }

    public Observable<List<Place>> getPlaceList() {
        return service.getPlaceList()
                .doOnError(Throwable::printStackTrace)
                .flatMap(cache::setPlaceList)
                .onErrorResumeNext(cache.getPlaceList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

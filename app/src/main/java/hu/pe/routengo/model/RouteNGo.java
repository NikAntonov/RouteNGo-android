package hu.pe.routengo.model;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.pe.routengo.entity.Objective;
import hu.pe.routengo.entity.Place;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Galya Sheremetova on 18.02.2017.
 */
@Singleton
public class RouteNGo {
    public static final String URL = "http://routengo.pe.hu/admin/api/";

    private RouteNGoApi service;
    private RouteNGoCache cache;

    @Inject
    public RouteNGo(RouteNGoApi service, RouteNGoCache cache) {
        this.service = service;
        this.cache = cache;
    }

    public Observable<List<Place>> getFullPlaceList() {
        return service.getFullPlaceList()
                .flatMap(cache::setPlaceList)
                .onErrorResumeNext(cache.getPlaceList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<Place>> getPlaceList(String type) {
        return service.getPlaceList(type)
                .onErrorResumeNext(cache.getPlaceList(type))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<Objective>> getObjectives() {
        return cache.getObjectives().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

package hu.pe.routengo.model;

import java.util.List;

import javax.inject.Inject;

import hu.pe.routengo.entity.Place;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Galya Sheremetova on 18.02.2017.
 */

public class RouteNGo {
    public static final String URL = "http://routengo.pe.hu/admin/api/";

    private RouteNGoService service;

    @Inject
    public RouteNGo(RouteNGoService service) {
        this.service = service;
    }

    public Observable<List<Place>> getPlaceList() {
        return service.getPlaceList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

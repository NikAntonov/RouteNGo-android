package hu.pe.routengo.model;

import javax.inject.Inject;

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
}

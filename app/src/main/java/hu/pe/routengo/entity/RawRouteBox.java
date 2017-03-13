package hu.pe.routengo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by megaman on 13.03.2017.
 */

public class RawRouteBox {
    @SerializedName("routes")
    @Expose
    private List<Route> routes;
    @SerializedName("status")
    @Expose
    private String status;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

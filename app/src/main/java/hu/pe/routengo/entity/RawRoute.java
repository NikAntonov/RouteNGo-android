package hu.pe.routengo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by megaman on 13.03.2017.
 */

public class RawRoute {
    @SerializedName("overview_polyline")
    @Expose
    private OverviewPolyline overviewPolyline;
    @SerializedName("waypoint_order")
    @Expose
    private List<Integer> waypointOrder ;

    public OverviewPolyline getOverviewPolyline() {
        return overviewPolyline;
    }

    public void setOverviewPolyline(OverviewPolyline overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
    }

    public List<Integer> getWaypointOrder() {
        return waypointOrder;
    }

    public void setWaypointOrder(List<Integer> waypointOrder) {
        this.waypointOrder = waypointOrder;
    }
}

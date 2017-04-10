package hu.pe.routengo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by megaman on 09.04.2017.
 */

public class Filter {
    private Map<String, Boolean> map = new HashMap<>();

    public Filter() {
        map.put("", true);
    }

    public void setHistory(boolean history) {
        map.put("history", history);
    }

    public void setShopping(boolean shopping) {
        map.put("shopping", shopping);
    }

    public void setBar(boolean bar) {
        map.put("bar", bar);
    }

    public void setNature(boolean nature) {
        map.put("nature", nature);
    }

    public void setFootball(boolean football) {
        map.put("football", football);
    }

    public boolean isHistory() {
        return map.get("history");
    }

    public boolean isShopping() {
        return map.get("shopping");
    }

    public boolean isBar() {
        return map.get("bar");
    }

    public boolean isNature() {
        return map.get("nature");
    }

    public boolean isFootball() {
        return map.get("football");
    }

    public boolean predicate(Place place) {
        return map.get(place.getType());
    }
}

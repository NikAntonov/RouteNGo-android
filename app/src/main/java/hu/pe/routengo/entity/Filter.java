package hu.pe.routengo.entity;

/**
 * Created by megaman on 09.04.2017.
 */

public class Filter {
    protected boolean history;
    protected boolean shopping;
    protected boolean bar;
    protected boolean nature;
    protected boolean football;

    public void setHistory(boolean history) {
        this.history = history;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    public void setFootball(boolean football) {
        this.football = football;
    }

    public boolean history(Place place) {
        return place.getType().equals("history");
    }

    public boolean shopping(Place place) {
        return place.getType().equals("shopping");
    }

    public boolean bar(Place place) {
        return place.getType().equals("bar");
    }

    public boolean nature(Place place) {
        return place.getType().equals("nature");
    }

    public boolean football(Place place) {
        return place.getType().equals("football");
    }
}

package hu.pe.routengo;

import javax.inject.Singleton;

import dagger.Component;
import hu.pe.routengo.presenter.PlacesActivity;

@Singleton
@Component(modules = {ServiceModule.class, CacheModule.class})
public interface RouteNGoComponent {
    void inject(PlacesActivity placesActivity);
}

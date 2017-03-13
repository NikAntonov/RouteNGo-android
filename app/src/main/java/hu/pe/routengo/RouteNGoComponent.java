package hu.pe.routengo;

import javax.inject.Singleton;

import dagger.Component;

import hu.pe.routengo.presenter.IntroActivity;
import hu.pe.routengo.presenter.MainActivity;
import hu.pe.routengo.presenter.PlacesActivity;

@Singleton
@Component(modules = {RouteNGoModule.class, CacheModule.class})
public interface RouteNGoComponent {
    void inject(MainActivity activity);
    void inject(PlacesActivity activity);
    void inject(IntroActivity activity);
}

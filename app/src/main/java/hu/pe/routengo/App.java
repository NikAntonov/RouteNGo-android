package hu.pe.routengo;

import android.support.multidex.MultiDexApplication;

public class App extends MultiDexApplication {

    private RouteNGoComponent component;

    public RouteNGoComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerRouteNGoComponent.builder()
                .serviceModule(new ServiceModule())
                .cacheModule(new CacheModule(this))
                .build();
    }
}

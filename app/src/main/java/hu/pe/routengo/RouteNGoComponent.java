package hu.pe.routengo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Galya Sheremetova on 18.02.2017.
 */
@Singleton
@Component(modules = {ServiceModule.class, CacheModule.class})
public class RouteNGoComponent {
}

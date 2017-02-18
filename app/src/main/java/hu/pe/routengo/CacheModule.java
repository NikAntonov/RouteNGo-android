package hu.pe.routengo;

import android.content.Context;

import dagger.Module;

/**
 * Created by Galya Sheremetova on 18.02.2017.
 */
@Module
public class CacheModule {
    private Context context;

    public CacheModule(Context context) {
        this.context = context;
    }

   /* @Provides
    @Singleton
    Noodle noodle() {
        return Noodle.with(context)
                .addType(Car.class)
                .build();
    }*/

}

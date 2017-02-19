package hu.pe.routengo;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.pe.routengo.entity.Models;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.reactivex.ReactiveEntityStore;
import io.requery.reactivex.ReactiveSupport;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;
import io.requery.sql.TableCreationMode;

/**
 * Created by Galya Sheremetova on 18.02.2017.
 */
@Module
public class CacheModule {
    private Context context;

    public CacheModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    ReactiveEntityStore<Persistable> dataStore() {
        ReactiveEntityStore<Persistable> dataStore;
        DatabaseSource source = new DatabaseSource(context, Models.DEFAULT, 1);
        if (BuildConfig.DEBUG) {
            // use this in development mode to drop and recreate the tables on every upgrade
            source.setTableCreationMode(TableCreationMode.DROP_CREATE);
        }
        Configuration configuration = source.getConfiguration();
        dataStore = ReactiveSupport.toReactiveStore(
                new EntityDataStore<Persistable>(configuration));
        return dataStore;
    }
}

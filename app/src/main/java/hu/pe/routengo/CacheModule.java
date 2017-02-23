package hu.pe.routengo;

import android.content.Context;

import java.util.Arrays;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.pe.routengo.entity.Models;
import hu.pe.routengo.entity.Objective;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.reactivex.ReactiveEntityStore;
import io.requery.reactivex.ReactiveSupport;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;
import io.requery.sql.TableCreationMode;

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
            source.setTableCreationMode(TableCreationMode.DROP_CREATE);
        }
        Configuration configuration = source.getConfiguration();
        dataStore = ReactiveSupport.toReactiveStore(new EntityDataStore<Persistable>(configuration));

        dataStore.insert(Arrays.asList(
                new Objective("history", "Historical Places", R.drawable.history_black),
                new Objective("shopping", "Shopping", R.drawable.shop_black),
                new Objective("bar", "Bar Megaphones", R.drawable.bar_black),
                new Objective("park", "Parks and Nature", R.drawable.nature_black),
                new Objective("football", "Football", R.drawable.football_black))).subscribe();
        return dataStore;
    }
}

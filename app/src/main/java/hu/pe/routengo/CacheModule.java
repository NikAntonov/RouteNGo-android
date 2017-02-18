package hu.pe.routengo;

/**
 * Created by Galya Sheremetova on 18.02.2017.
 */
//@Module
public class CacheModule {
   /* private Context context;

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
    }*/
}

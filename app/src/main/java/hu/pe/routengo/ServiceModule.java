package hu.pe.routengo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.pe.routengo.model.RouteNGo;
import hu.pe.routengo.model.RouteNGoService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Galya Sheremetova on 18.02.2017.
 */

//@Module
public class ServiceModule {
   /* @Provides
    @Singleton
    OkHttpClient client() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Provides
    @Singleton
    Retrofit retrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(RouteNGo.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client).build();
    }

    @Provides
    @Singleton
    RouteNGoService dvinnerService(Retrofit retrofit) {
        return retrofit.create(RouteNGoService.class);
    }*/
}

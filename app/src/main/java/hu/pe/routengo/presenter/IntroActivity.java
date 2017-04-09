package hu.pe.routengo.presenter;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.paolorotolo.appintro.AppIntroFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.Locale;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.adapter.InterestAdapter;
import hu.pe.routengo.adapter.IntroAdapter;
import hu.pe.routengo.model.RouteNGo;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class IntroActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    @Inject
    RouteNGo routeNGo;
    InterestAdapter adapter;
    GoogleApiClient client;
    LocationRequest request;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        /*setBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        setSeparatorColor(ContextCompat.getColor(this, R.color.colorPrimary));*/
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        IntroAdapter pagerAdapter = new IntroAdapter(getSupportFragmentManager());


        ((App) getApplication()).getComponent().inject(this);

        pagerAdapter.setFragments(AppIntroFragment.newInstance("Welcome!", "For creating routes we need to know what are you like",
                R.drawable.man, ContextCompat.getColor(this, R.color.colorPrimary)),
                new InterestFragment(routeNGo.getInterests().map(InterestAdapter::new)
                        .doOnSuccess(adapter -> this.adapter = adapter)),
                AppIntroFragment.newInstance("Location", "We need to know your location to use main features to Route'N'Go",
                        R.drawable.location_white, ContextCompat.getColor(this, R.color.colorPrimary)),
                new LetGoFragment());
        viewPager.setAdapter(pagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_intro);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("types", adapter.getTypes());
            setResult(RESULT_OK, intent);
            finish();
        });

        client = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        request = LocationRequest.create().setNumUpdates(1)
                .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i("tag", "onConnected");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(client, request, location ->
                Completable.complete().subscribeOn(Schedulers.io()).subscribe(() -> {
                    Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                    Address address = geocoder.getFromLocation(
                            location.getLatitude(), location.getLongitude(), 1).get(0);
                    String locality = address.getLocality();
                    Log.i("tag", "!!!!!" + locality);
                    SharedPreferences preferences =
                            PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    preferences.edit().putString("city", locality).apply();
                }, Throwable::printStackTrace));
        // Location location = LocationServices.FusedLocationApi.getLastLocation(client);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("tag", "onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i("tag", "onConnectionFailed");
    }

    protected void onStart() {
        client.connect();
        super.onStart();
    }

    protected void onStop() {

        client.disconnect();
        super.onStop();
    }
}



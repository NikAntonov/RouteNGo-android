package hu.pe.routengo.presenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.paolorotolo.appintro.AppIntroFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.adapter.InterestAdapter;
import hu.pe.routengo.adapter.IntroAdapter;
import hu.pe.routengo.model.FetchAddressIntentService;
import hu.pe.routengo.model.RouteNGo;

public class IntroActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final String RESULT_DATA_KEY = "rdk";
    public static final String RECEIVER = "r";
    public static final String LOCATION_DATA_EXTRA = "lde";
    @Inject
    RouteNGo routeNGo;
    InterestAdapter adapter;
    GoogleApiClient client;
    AddressResultReceiver mResultReceiver;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        /*setBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        setSeparatorColor(ContextCompat.getColor(this, R.color.colorPrimary));*/
        client = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();


        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        IntroAdapter pagerAdapter = new IntroAdapter(getSupportFragmentManager());


        ((App) getApplication()).getComponent().inject(this);

        pagerAdapter.setFragments(AppIntroFragment.newInstance("Welcome!", "For creating routes we need to know what are you like",
                R.drawable.man, ContextCompat.getColor(this, R.color.colorPrimary)),
                new InterestFragment(routeNGo.getObjectives().map(InterestAdapter::new)
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
    }

    @SuppressWarnings("MissingPermission")
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(client);

        Intent intent = new Intent(this, FetchAddressIntentService.class);
        intent.putExtra(RECEIVER, mResultReceiver);
        intent.putExtra(LOCATION_DATA_EXTRA, lastLocation);
        startService(intent);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    protected void onStart() {
        client.connect();
        super.onStart();
    }

    protected void onStop() {
        client.disconnect();
        super.onStop();
    }

    private class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {

            // Display the address string
            // or an error message sent from the intent service.
            String addressOutput = resultData.getString(RESULT_DATA_KEY);

            SharedPreferences preferences =
                    PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            preferences.edit().putString("city", addressOutput).apply();
        }
    }
}



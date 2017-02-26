package hu.pe.routengo.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.pe.routengo.R;
import hu.pe.routengo.entity.Place;
import hu.pe.routengo.entity.Route;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    FloatingActionButton fab;
    Route route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_map);
        setSupportActionBar(toolbar);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LinearLayout llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(view -> {

        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Gson gson = new GsonBuilder().create();
        String string = getIntent().getStringExtra("route");
        route = gson.fromJson(string, Route.class);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        PolylineOptions polylineOptions = new PolylineOptions();
        MarkerOptions markerOptions = new MarkerOptions();
        List<Place> places = route.getPlaceList();
        List<LatLng> list = new ArrayList<>(places.size());
        for (Place place : places) {
            LatLng latLng = new LatLng(Double.parseDouble(place.getXLatLng()), Double.parseDouble(place.getYLatLng()));
            list.add(latLng);
            // polylineOptions.add(latLng);
            map.addMarker(markerOptions.position(latLng));
        }
        Collections.sort(list, (LatLng l1, LatLng o2) -> Double.compare(l1.latitude, o2.latitude)
        );
        LatLng latLng1 = list.get(0);
        LatLng latLng2 = list.get(list.size() - 1);
        polylineOptions.addAll(list);
        map.addPolyline(polylineOptions);
        //map.addMarker(new MarkerOptions().position(new LatLng(-34, 151)));
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(latLng1, latLng2), 1));
        map.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        LinearLayout llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (BottomSheetBehavior.STATE_DRAGGING == newState) {
                    fab.animate().scaleX(0).scaleY(0).setDuration(300).start();
                } else if ((BottomSheetBehavior.STATE_COLLAPSED == newState) || (BottomSheetBehavior.STATE_HIDDEN == newState)) {
                    fab.animate().scaleX(1).scaleY(1).setDuration(300).start();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {
      /*  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
        super.onBackPressed();
    }
}

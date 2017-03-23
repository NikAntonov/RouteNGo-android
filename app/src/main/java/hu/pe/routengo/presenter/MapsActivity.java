package hu.pe.routengo.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Route;
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

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    FloatingActionButton fab;

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
    }

    @Override
    public void onMapReady(GoogleMap map) {
        MarkerOptions markerOptions = new MarkerOptions();
        Gson gson = new GsonBuilder().create();
        String string = getIntent().getStringExtra("route");

        List<Place> places = gson.fromJson(string, hu.pe.routengo.entity.Route.class).getPlaces();
        Log.i("tag", String.valueOf(places.size()));
        List<LatLng> waypoints = new ArrayList<>(places.size());
        for (Place place : places) {
            if (!place.getXLatLng().equals("0")) {
                LatLng latLng = new LatLng(Double.parseDouble(place.getXLatLng()), Double.parseDouble(place.getYLatLng()));
                waypoints.add(latLng);
                map.addMarker(markerOptions.position(latLng));
            }
        }
        //Log.i("tag", String.valueOf(waypoints.size()));
        Collections.sort(waypoints, (LatLng l1, LatLng o2) -> Double.compare(l1.latitude, o2.latitude));

        GoogleDirection.withServerKey("AIzaSyDUy3ZlCR2WJD-06m6uL9aNsYz9EEVSjDc")
                .from(waypoints.get(0))
                .to(waypoints.get(waypoints.size() - 1))
                .waypoints(waypoints.subList(1, waypoints.size() - 1))
                .transportMode(TransportMode.WALKING)
                .execute(new DirectionCallback() {
                    @Override
                    public void onDirectionSuccess(Direction direction, String rawBody) {
                        if (direction.isOK()) {
                            Route route = direction.getRouteList().get(0);
                            map.addPolyline(new PolylineOptions().addAll(route.getOverviewPolyline().getPointList()));
                            LatLngBounds bounds = new LatLngBounds(
                                    route.getBound().getSouthwestCoordination().getCoordination(),
                                    route.getBound().getNortheastCoordination().getCoordination());
                            map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 10));
                        } else {
                            // Do something
                        }
                    }

                    @Override
                    public void onDirectionFailure(Throwable t) {
                        // Do something
                    }
                });


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

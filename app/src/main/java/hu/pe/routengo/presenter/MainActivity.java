package hu.pe.routengo.presenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.adapter.RouteAdapter;
import hu.pe.routengo.entity.Route;
import hu.pe.routengo.model.RouteNGo;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    RouteNGo routeNGo;

    private GoogleMap mMap;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(intent);
            });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ((App) getApplication()).getComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        // Completable.complete().subscribeOn(Schedulers.io()).subscribe(() -> {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean isFirstStart = preferences.getBoolean("firstStart", true);
        if (isFirstStart || true) {
            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
            startActivityForResult(intent, 1);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();
        }
        // });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            List<String> types = data.getStringArrayListExtra("types");
            Log.i("tag", "++++++++++++" + types.get(0));
            Observable.fromIterable(types)
                    .flatMap(type -> routeNGo.getPlaceList(type)
                            .flatMap(placeList -> Observable.just(new Route())
                                    .doOnNext(route -> route.setType(type))
                                    .doOnNext(route -> route.getPlaceList().addAll(placeList))
                            )).toList().map(RouteAdapter::new)
                    .subscribe(recyclerView::setAdapter);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_map) {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

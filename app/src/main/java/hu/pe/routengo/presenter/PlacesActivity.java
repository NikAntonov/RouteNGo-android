package hu.pe.routengo.presenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;

import com.jakewharton.rxbinding2.widget.RxCompoundButton;

import java.util.Arrays;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.adapter.PlaceAdapter;
import hu.pe.routengo.entity.Filter;
import hu.pe.routengo.model.RouteNGo;
import io.reactivex.Observable;

public class PlacesActivity extends AppCompatActivity {
    @Inject
    RouteNGo routeNGo;
    RecyclerView recyclerView;
    Filter filter = new Filter();

    Switch historySwitch;
    Switch shoppingSwitch;
    Switch barSwitch;
    Switch natureSwitch;
    Switch footballSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        toolbar.setTitle(preferences.getString("city", "Default-City"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
                Intent intent = new Intent(PlacesActivity.this, MapsActivity.class);
                startActivity(intent);
        });
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((App) getApplication()).getComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_places);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(itemAnimator);

        historySwitch = (Switch) findViewById(R.id.history_switch);
        shoppingSwitch = (Switch) findViewById(R.id.shopping_switch);
        barSwitch = (Switch) findViewById(R.id.bar_switch);
        natureSwitch = (Switch) findViewById(R.id.nature_switch);
        footballSwitch = (Switch) findViewById(R.id.football_switch);

        routeNGo.getFullPlaceList().doOnNext(places -> {
            historySwitch.setChecked(true);
            shoppingSwitch.setChecked(true);
            barSwitch.setChecked(true);
            natureSwitch.setChecked(true);
            footballSwitch.setChecked(true);
        }).flatMap(list -> Observable.merge(Arrays.asList(
                RxCompoundButton.checkedChanges(historySwitch).doOnNext(filter::setHistory),
                RxCompoundButton.checkedChanges(shoppingSwitch).doOnNext(filter::setShopping),
                RxCompoundButton.checkedChanges(barSwitch).doOnNext(filter::setBar),
                RxCompoundButton.checkedChanges(natureSwitch).doOnNext(filter::setNature),
                RxCompoundButton.checkedChanges(footballSwitch).doOnNext(filter::setFootball)))
                .map(isChecked -> list).flatMap(places -> Observable.fromIterable(places)
                        .filter(filter::predicate).toList().toObservable()))
                .map(PlaceAdapter::new).subscribe(recyclerView::setAdapter, Throwable::printStackTrace);
    }
}

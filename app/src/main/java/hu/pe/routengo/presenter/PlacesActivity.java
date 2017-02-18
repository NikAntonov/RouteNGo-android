package hu.pe.routengo.presenter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import hu.pe.routengo.R;
import hu.pe.routengo.adapter.PlaceListAdapter;
import hu.pe.routengo.adapter.RouteListAdapter;
import hu.pe.routengo.entity.Place;
import hu.pe.routengo.entity.Route;

public class PlacesActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Place> placesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        placesList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            placesList.add(new Place());
        }

        rv = (RecyclerView) findViewById(R.id.rv_places);
        if (rv != null) {
            rv.setHasFixedSize(true);
            rv.setLayoutManager(new LinearLayoutManager(this));
            PlaceListAdapter adapter = new PlaceListAdapter(placesList);
            rv.setAdapter(adapter);
            RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
            rv.setItemAnimator(itemAnimator);
        }
    }

}

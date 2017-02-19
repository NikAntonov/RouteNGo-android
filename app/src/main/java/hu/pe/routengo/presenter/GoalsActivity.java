package hu.pe.routengo.presenter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.model.RouteNGoCache;

public class GoalsActivity extends AppCompatActivity {

    @Inject
    RouteNGoCache routeNGo;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(v -> {

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((App) getApplication()).getComponent().inject(this);

        rv = (RecyclerView) findViewById(R.id.rv_goals);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        rv.setItemAnimator(itemAnimator);

        //routeNGo.getPlaceList().map(PlaceListAdapter::new).subscribe(rv::setAdapter, Throwable::printStackTrace);
    }
}
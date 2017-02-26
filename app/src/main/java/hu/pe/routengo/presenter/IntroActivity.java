package hu.pe.routengo.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.paolorotolo.appintro.AppIntroFragment;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.adapter.InterestAdapter;
import hu.pe.routengo.adapter.IntroAdapter;
import hu.pe.routengo.model.RouteNGo;

public class IntroActivity extends AppCompatActivity {
    @Inject
    RouteNGo routeNGo;
    private InterestAdapter adapter;

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

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

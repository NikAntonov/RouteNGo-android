package hu.pe.routengo.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.adapter.GoalsAdapter;
import hu.pe.routengo.adapter.SampleSlide;
import hu.pe.routengo.model.RouteNGoCache;

/**
 * Created by anton on 19.02.2017.
 */

public class IntroActivity extends AppIntro {
    private RecyclerView rv;
    @Inject
    RouteNGoCache cache;
    private GoalsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Welcome!", "For creating routes we need to know what are you like", R.drawable.man, getResources().getColor(R.color.colorPrimary)));
        addSlide(SampleSlide.newInstance(R.layout.intro_slide_interests));
        addSlide(AppIntroFragment.newInstance("Location", "We need to know your location to use main features to Route'N'Go", R.drawable.location_white, getResources().getColor(R.color.colorPrimary)));
        addSlide(SampleSlide.newInstance(R.layout.intro_slide_letgo));

        setBarColor(getResources().getColor(R.color.colorPrimary));
        setSeparatorColor(getResources().getColor(R.color.colorPrimary));

        showSkipButton(false);
        setProgressButtonEnabled(true);

        setVibrate(true);
        setVibrateIntensity(30);

        ((App) getApplication()).getComponent().inject(this);

        rv = (RecyclerView) findViewById(R.id.rv_goals);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        rv.setItemAnimator(itemAnimator);

        cache.getObjectives().subscribe(objectives -> {
            setAdapter(new GoalsAdapter(objectives));
            rv.setAdapter(adapter);
        });
    }

    private void setAdapter(GoalsAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        getIntent().putStringArrayListExtra("names", adapter.getNames());
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}

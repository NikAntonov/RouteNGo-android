package hu.pe.routengo.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.pe.routengo.App;
import hu.pe.routengo.R;
import hu.pe.routengo.adapter.GoalsAdapter;
import hu.pe.routengo.adapter.SampleSlide;
import hu.pe.routengo.entity.Objective;
import hu.pe.routengo.model.RouteNGoCache;

/**
 * Created by anton on 19.02.2017.
 */

public class IntroActivity extends AppIntro {
    private List<Objective> interestsList;
    private RecyclerView rv;
    @Inject
    private RouteNGoCache cache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
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

        interestsList = new ArrayList<>();

        ((App) getApplication()).getComponent().inject(this);

        rv = (RecyclerView) findViewById(R.id.rv_goals);
        GoalsAdapter adapter = new GoalsAdapter(interestsList);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        rv.setItemAnimator(itemAnimator);

        cache.getObjectives().map(GoalsAdapter::new).subscribe(rv::setAdapter, Throwable::printStackTrace);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}

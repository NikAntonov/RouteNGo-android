package hu.pe.routengo.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

public class IntroActivity extends AppIntro {
    @Inject
    RouteNGoCache cache;
    private GoalsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance("Welcome!", "For creating routes we need to know what are you like",
                R.drawable.man, ContextCompat.getColor(this, R.color.colorPrimary)));
        addSlide(SampleSlide.newInstance(R.layout.intro_slide_interests));
        addSlide(AppIntroFragment.newInstance("Location", "We need to know your location to use main features to Route'N'Go",
                R.drawable.location_white, ContextCompat.getColor(this, R.color.colorPrimary)));
        addSlide(SampleSlide.newInstance(R.layout.intro_slide_letgo));

        setBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        setSeparatorColor(ContextCompat.getColor(this, R.color.colorPrimary));
        showSkipButton(false);
        setProgressButtonEnabled(true);
        setVibrate(true);
        setVibrateIntensity(30);

        ((App) getApplication()).getComponent().inject(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_goals);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(itemAnimator);

        cache.getObjectives().map(GoalsAdapter::new)
                .doOnSuccess(this::setAdapter)
                .subscribe(recyclerView::setAdapter);
    }

    private void setAdapter(GoalsAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("names", adapter.getNames());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}

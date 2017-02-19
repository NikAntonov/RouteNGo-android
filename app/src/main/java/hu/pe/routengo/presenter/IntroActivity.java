package hu.pe.routengo.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

import hu.pe.routengo.R;
import hu.pe.routengo.adapter.SampleSlide;

/**
 * Created by anton on 19.02.2017.
 */

public class IntroActivity extends AppIntro {
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

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);

        interestsList = new ArrayList<>();

        rv = (RecyclerView) findViewById(R.id.rv_goals);
        GoalsAdapter adapter = new GoalsAdapter(interestsList);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        rv.setItemAnimator(itemAnimator);


        //routeNGo.getPlaceList().map(PlaceListAdapter::new).subscribe(rv::setAdapter, Throwable::printStackTrace);
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

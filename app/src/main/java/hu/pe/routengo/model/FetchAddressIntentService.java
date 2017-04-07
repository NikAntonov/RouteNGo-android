package hu.pe.routengo.model;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

import java.util.Locale;

import hu.pe.routengo.presenter.IntroActivity;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class FetchAddressIntentService extends IntentService {
    public static final String LOCATION = "loc";
    private static final int SUCCESS_RESULT = 0;
    private static final String RESULT_DATA_KEY = "rdk";

    public FetchAddressIntentService() {
        super("FetchAddressIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        Location location = intent.getParcelableExtra(LOCATION);

        Address address = null;
        try {
            address = geocoder.getFromLocation(
                    location.getLatitude(), location.getLongitude(), 1).get(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        ResultReceiver receiver = intent.getParcelableExtra(intent.getParcelableExtra(IntroActivity.RECEIVER));
        Bundle bundle = new Bundle();
        String message = address.getLocality();
        bundle.putString(RESULT_DATA_KEY, message);
        receiver.send(SUCCESS_RESULT, bundle);


    }
}

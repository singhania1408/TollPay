package digiwizards.sih.com.tollpay.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationResult;

import java.util.List;

import static com.google.android.gms.location.LocationAvailability.hasLocationAvailability;
import static com.google.android.gms.location.LocationResult.extractResult;
import static com.google.android.gms.location.LocationResult.hasResult;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * helper methods.
 */
public class LocationReceiveService extends IntentService {
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_LOCATION = "digiwizards.sih.com.tollpay.service.action.LOCATION";

    private static final String EXTRA_PARAM1 = "digiwizards.sih.com.tollpay.notification.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "digiwizards.sih.com.tollpay.notification.extra.PARAM2";
    private final String TAG = getClass().getSimpleName();


    List<Location> locationList;
    Location lastLocation;

    public LocationReceiveService() {
        super("LocationReceiveService");
    }


    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, LocationReceiveService.class);
        //intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public static Intent getLocationIntent(Context context) {
        Intent intent = new Intent(context, LocationReceiveService.class);
        intent.setAction(ACTION_LOCATION);
       /* intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);*/
       return intent;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_LOCATION.equals(action)) {
                if(hasResult(intent)){
                        handleActionLocation(intent);
                }
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
            } /*else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }*/
        }
    }

    /**
     * Handle action Location in the provided background thread with the provided
     * parameters.
     */
    private void handleActionLocation(Intent intent) {
        LocationResult locationResult=extractResult(intent);
        locationList=locationResult.getLocations();
        lastLocation=locationResult.getLastLocation();

        Log.v(TAG,"Yeaah Location is getting"+lastLocation.getSpeed()+" "+lastLocation.getLongitude()
                +" "+lastLocation.getLatitude());
        Toast.makeText(this,"Yeaah Location is getting"+lastLocation.getSpeed()+" "+lastLocation.getLongitude()
                +" "+lastLocation.getLatitude(),Toast.LENGTH_SHORT).show();
    }

}

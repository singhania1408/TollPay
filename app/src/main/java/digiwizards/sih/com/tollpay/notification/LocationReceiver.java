package digiwizards.sih.com.tollpay.notification;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

import java.util.List;

import digiwizards.sih.com.tollpay.R;

import static com.google.android.gms.location.LocationAvailability.extractLocationAvailability;
import static com.google.android.gms.location.LocationAvailability.hasLocationAvailability;
import static com.google.android.gms.location.LocationResult.extractResult;
import static com.google.android.gms.location.LocationResult.hasResult;

public class LocationReceiver extends AppCompatActivity {

    List<Location> locationList;
    Location lastLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_receiver);

        if(hasResult(getIntent())){
            if(hasLocationAvailability(getIntent())){
                LocationResult locationResult=extractResult(getIntent());
                locationList=locationResult.getLocations();
                lastLocation=locationResult.getLastLocation();

                Toast.makeText(this,"Yeaah Location is getting"+lastLocation.getSpeed()+" "+lastLocation.getLongitude()
                        +" "+lastLocation.getLatitude(),Toast.LENGTH_SHORT).show();
            }
        }

    }
}

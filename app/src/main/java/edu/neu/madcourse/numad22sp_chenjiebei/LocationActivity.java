package edu.neu.madcourse.numad22sp_chenjiebei;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;

import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationRequest;


import java.util.List;


public class LocationActivity extends AppCompatActivity {

    private LocationCallback locationCallback;
    private LocationRequest mLocationRequest;
    private FusedLocationProviderClient fusedLocationClient;
    private boolean requestingLocationUpdates;
    private TextView mlatitue;
    private TextView mlongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mlatitue = (TextView) findViewById(R.id.textView6);
        mlongitude = (TextView) findViewById(R.id.textView7);

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            requestingLocationUpdates = true;
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // In an educational UI, explain to the user why your app requires this
            // permission for a specific feature to behave as expected. In this UI,
            // include a "cancel" or "no thanks" button that allows the user to
            // continue using your app without granting the permission.
            showInContextUI();
        } else {
            // You can directly ask for the permission.
            doRequestLocationPermission();
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                List<Location> locationList = locationResult.getLocations();
                if (locationResult == null) {
                    return;
                }
                Location location = locationList.get(locationList.size() - 1);
                mlatitue.setText(location.getLatitude()+"");
                mlongitude.setText(location.getLongitude()+"");
                /*
                for (Location location : locationResult.getLocations()) {
                    // Update UI with location data
                    // ...
                }*/
            }
        };

    }


    private void doRequestLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
    }

    private void showInContextUI() {
        new AlertDialog.Builder(this).setTitle("Location Permission Needed")
                .setMessage("This app needs the Location permission, please accept to use location functionality")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        doRequestLocationPermission();
                    }
                }).create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //mLocationPermissionGranted = false;

        if (requestCode != 0) {
            return;
        }

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            requestingLocationUpdates = true;

        } else {
            // permission denied, boo! Disable the
            // functionality that depends on this permission.
            Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (requestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    private void startLocationUpdates() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationRequest locationRequest=new LocationRequest();
        fusedLocationClient.requestLocationUpdates(locationRequest,
                locationCallback,
                Looper.getMainLooper());
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    private void stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback);
    }


    /*
    protected LocationRequest createLocationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000); //间隔10s
        locationRequest.setFastestInterval(5000); //可以处理的最快间隔
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return locationRequest;
       // LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
         //       .addLocationRequest(locationRequest);
    }*/




}
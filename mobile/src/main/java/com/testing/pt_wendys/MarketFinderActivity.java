package com.testing.pt_wendys;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import static java.security.AccessController.getContext;


public class MarketFinderActivity extends FragmentActivity implements OnMapReadyCallback {
    public static final int MY_PERMISSION_REQUEST_LOCATION = 0;
    int LOCATION_PERMISSION_REQUEST_CODE = 0;
    private GoogleMap mMap;

    private boolean doesUserHavePermission()
    {
        int result = getApplicationContext().checkCallingOrSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_finder);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d("we", "got permission");
                } else {
                    Log.d("we", "got denied!");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSION_REQUEST_LOCATION);

                // MY_PERMISSION_REQUEST_LOCATION is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        if (doesUserHavePermission()){
            Log.d("my permission: ", "is granted!");
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            //LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        } else {
            Log.d("my permission: ", "is denied ... !");
        }

        //int permissionCheck = ContextCompat.checkSelfPermission(this,
        //        android.Manifest.permission.ACCESS_FINE_LOCATION);
        //mMap.setMyLocationEnabled(true);
        //Location myLocation = mMap.getMyLocation();

        //mMap.addMarker(new MarkerOptions().position(new LatLng(myLocation.getLatitude(), myLocation.getLongitude())).title("It's Me!"));

        // Add a marker in Sydney and move the camera
        //LatLng me = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
        //mMap.addMarker(new MarkerOptions().position(me).title("It's me!"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng());
    }
}

package com.example.relieved;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private LocationListener locationListener;
    private LocationManager locationManager;

    private final long MIN_UPDATE_TIME= 1000;
    private final long MIN_UPDATE_DIST=5;

    private LatLng latLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        LatLng YOGA_CENTER = new LatLng(17.5615400669499, 78.43500472921292);
        map.addMarker(new MarkerOptions().position(YOGA_CENTER).title("YOGA_CENTER"));
        map.moveCamera(CameraUpdateFactory.newLatLng(YOGA_CENTER));


        LatLng ELVOGUE_SPA = new LatLng(17.567784730039737, 78.4641313953177);
        map.addMarker(new MarkerOptions().position(ELVOGUE_SPA).title("ELVOGUE_SPA"));
        map.moveCamera(CameraUpdateFactory.newLatLng(ELVOGUE_SPA));

        LatLng AROGYA_YOGA_CENTER = new LatLng(17.463871733733324, 78.42104461396849);
        map.addMarker(new MarkerOptions().position(AROGYA_YOGA_CENTER).title("AROGYA_YOGA_CENTER"));
        map.moveCamera(CameraUpdateFactory.newLatLng(AROGYA_YOGA_CENTER));

        LatLng INDIAN_YOGA = new LatLng(17.446899917169166, 78.46644078784391);
        map.addMarker(new MarkerOptions().position(INDIAN_YOGA).title("INDIAN_YOGA"));
        map.moveCamera(CameraUpdateFactory.newLatLng(INDIAN_YOGA));

        LatLng BLOOM_HOSPITALS_KOMPALLY  = new LatLng(17.525581635483455, 78.48310194670734);
        map.addMarker(new MarkerOptions().position(BLOOM_HOSPITALS_KOMPALLY).title("BLOOM_HOSPITALS_KOMPALLY"));
        map.moveCamera(CameraUpdateFactory.newLatLng(BLOOM_HOSPITALS_KOMPALLY));

        LatLng MALLAREDDY_HOSPITALS = new LatLng(17.54481534056321, 78.43287453586807);
        map.addMarker(new MarkerOptions().position(MALLAREDDY_HOSPITALS).title("MALLAREDDY_HOSPITALS"));
        map.moveCamera(CameraUpdateFactory.newLatLng(MALLAREDDY_HOSPITALS));





        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());


                    map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    MarkerOptions options =new MarkerOptions().position(latLng).title("My Current Position");
                    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
                    map.addMarker(options);
                }
                catch (SecurityException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_UPDATE_DIST,MIN_UPDATE_TIME, locationListener);
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
    }
}

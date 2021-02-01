package com.example.pesquisadepartes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

//    @BindView(R.id.toolbar)
//    Toolbar toolbar;

    FusedLocationProviderClient fusedLocationProviderClient;
    GoogleMap mMap;
    Marker marker;
    LocationRequest locationRequest;
    TextView textView;
    int dadosId;
    Location lastLocation;

    LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        ButterKnife.bind(this);
        textView = findViewById(R.id.textView);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        toolbar.setTitle("Current Location");
//        setSupportActionBar(toolbar);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        dadosId = getIntent().getIntExtra("dados", 0);
        Log.i("INFO", "sucessoMaps!" + dadosId);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        locationRequest = new LocationRequest();
        locationRequest.setInterval(7000);
        locationRequest.setFastestInterval(10000);
        locationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);

        requestLocationDialog();
        checkPermissionAndRequestLocation();

//        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
//            @Override
//            public void onMarkerDragStart(Marker marker) {
//
//            }
//
//            @Override
//            public void onMarkerDrag(Marker marker) {
//
//            }
//
//            @Override
//            public void onMarkerDragEnd(Marker marker) {
//
//            }
//        });
        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {

             @Override
             public void onCameraIdle() {
                 try {
                     if (lastLocation.getLatitude() < 0 && lastLocation.getLongitude() < 0) {
                         try {
                             Geocoder geo = new Geocoder(MapsActivity.this.getApplicationContext(), Locale.getDefault());
                             List<Address> addresses = geo.getFromLocation(lastLocation.getLatitude(), lastLocation.getLongitude(), 1);
                             if (addresses.isEmpty()) {
                                 textView.setText("Waiting for Location");
                             }
                             else {
                                 if (addresses.size() > 0) {
//                            textView.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
                                     //Toast.makeText(getApplicationContext(), "Address:- " + addresses.get(0).getFeatureName() + addresses.get(0).getAdminArea() + addresses.get(0).getLocality(), Toast.LENGTH_LONG).show();
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                                     Bundle b = new Bundle();
//                                     b.getInt("dadosIdMaps", dadosId);
//                                     b.getString("localMaps", addresses.get(0).getAddressLine(0));
//                                     intent.putExtra("Bundle", b);
                                     Intent intent = new Intent(MapsActivity.this, DadosActivity.class);
                                     intent.putExtra("local", addresses.get(0).getAddressLine(0) );
                                     intent.putExtra("dados", dadosId );
                                     startActivity( intent );
                                     finish();
//                        }
//                    });

                                 }
                             }
                         }
                         catch (Exception e) {
                             e.printStackTrace(); // getFromLocation() may sometimes fail
                         }

                         mMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                             @Override
                             public void onSnapshotReady(Bitmap bitmap) {
//                        mapPreview.setLayoutParams(new RelativeLayout.LayoutParams(
//                                ViewGroup.LayoutParams.MATCH_PARENT,
//                                ViewGroup.LayoutParams.MATCH_PARENT));
//                                mapPreview.setImageBitmap(bitmap);
                             }
                         });
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         });

        mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
//                try {
//                    if (lastLocation.getLatitude() < 0 && lastLocation.getLongitude() < 0) {
//                        try {
//                            Geocoder geo = new Geocoder(MapsActivity.this.getApplicationContext(), Locale.getDefault());
//                            List<Address> addresses = geo.getFromLocation(lastLocation.getLatitude(), lastLocation.getLongitude(), 1);
//                            if (addresses.isEmpty()) {
//                                textView.setText("Waiting for Location");
//                            }
//                            else {
//                                if (addresses.size() > 0) {
////                            textView.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
//                                    //Toast.makeText(getApplicationContext(), "Address:- " + addresses.get(0).getFeatureName() + addresses.get(0).getAdminArea() + addresses.get(0).getLocality(), Toast.LENGTH_LONG).show();
////                    button.setOnClickListener(new View.OnClickListener() {
////                        @Override
////                        public void onClick(View view) {
//                                    Intent intent = new Intent(MapsActivity.this, MainActivity.class);
//                                    intent.putExtra("local", addresses.get(0).getAddressLine(0) );
//                                    startActivity( intent );
////                        }
////                    });
//
//                                }
//                            }
//                        }
//                        catch (Exception e) {
//                            e.printStackTrace(); // getFromLocation() may sometimes fail
//                        }
//
//                        mMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
//                            @Override
//                            public void onSnapshotReady(Bitmap bitmap) {
////                        mapPreview.setLayoutParams(new RelativeLayout.LayoutParams(
////                                ViewGroup.LayoutParams.MATCH_PARENT,
////                                ViewGroup.LayoutParams.MATCH_PARENT));
////                                mapPreview.setImageBitmap(bitmap);
//                            }
//                        });
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void checkPermissionAndRequestLocation() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
                fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                        locationCallback, Looper.myLooper());

                mMap.setMyLocationEnabled(true);
            }
            else
            {
                checkForLocationPermission();
            }
        }
        else
        {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                    locationCallback, Looper.myLooper());

            mMap.setMyLocationEnabled(true);

        }
    }

    private void checkForLocationPermission()
    {
        if (!checkPermissions()) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, 1001);
        }
    }

    private boolean checkPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
            if (result == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private void requestLocationDialog() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        LocationSettingsRequest locationSettingsRequest = builder.build();

        SettingsClient settingsClient = LocationServices.getSettingsClient(this);

        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(locationSettingsRequest);

        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

            }
        });

        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }


    LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location: locationResult.getLocations()) {
                lastLocation = location;
            }

            if(marker != null) {
                marker.remove();
            }

            latLng = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Current Location");

            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
        }
    };
}
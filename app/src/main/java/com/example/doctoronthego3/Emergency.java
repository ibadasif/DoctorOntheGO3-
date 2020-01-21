package com.example.doctoronthego3;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class Emergency extends FragmentActivity implements OnMapReadyCallback, TaskLoadedCallback  {

    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final  int REQUEST_CODE =101;
    Button getDirection;
    MarkerOptions place1,place2 ;
    Polyline currentPolyLine;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        getDirection= findViewById(R.id.getDirection);
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();

        place1 = new MarkerOptions().position(new LatLng(24.9445, 67.1386)).title("Dow University Hospital");
        place2 = new MarkerOptions().position(new LatLng(24.8338, 67.0287)).title("Hilal-E-Ahmar House Hospital");

        getDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getUrl(place1.getPosition(),place2.getPosition(),"driving");
                new FetchURL(Emergency.this).execute(url,"driving");

            }
        });



    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode){
        String str_origin = "origin=" + origin.latitude+ "," + origin.longitude;
        String str_dest = "destination=" + dest.latitude+ "," + dest.longitude;
        String mode = "mode=" + directionMode;
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
        return url;
    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }

        Task<Location> task= fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null){
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()
                    +""+currentLocation.getLongitude(),Toast.LENGTH_LONG).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment)
                            getSupportFragmentManager().findFragmentById(R.id.google_map);
                    supportMapFragment.getMapAsync(Emergency.this);
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng= new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                .title("YOU ARE HERE");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
        googleMap.addMarker(markerOptions);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.addMarker(place1);
        googleMap.addMarker(place2);




    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }
                break;
        }
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyLine != null)
            currentPolyLine.remove();
        currentPolyLine = googleMap.addPolyline((PolylineOptions) values[0]);
    }
}

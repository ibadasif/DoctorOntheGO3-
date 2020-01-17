package com.example.doctoronthego3;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HosMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hos_map);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng aku = new LatLng(24.8920, 67.0747);
        mMap.addMarker(new MarkerOptions().position(aku).title("Aga Khan University Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aku));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.8916, 67.0681)).title("Liaquat National Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.9143, 67.1272)).title("Darul Sehat Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.9311, 67.0383)).title("Saifee Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.9201, 67.0297)).title("Abbasi Shaheed Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.8296, 67.0407)).title("Hashmanis Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.8520, 67.0442)).title("Jinnah Hospital Karachi"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.9247, 67.0455)).title("Dr. Ziauddin Hospital North Nazimabad Campus"));

    }
}

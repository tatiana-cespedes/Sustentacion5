package com.cespedes.tatiana.sustentacion5;


import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemografiaFragment extends Fragment {


    MapView mapView;
    GoogleMap map;

    public DemografiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_demografia, container, false);

        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
        LatLng lgaucha = new LatLng(6.9973952,-76.2718708);
        Location mia = new Location("hola");

        // LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        map.setMyLocationEnabled(true);
        mia = map.getMyLocation();
        MapsInitializer.initialize(this.getActivity());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(lgaucha, 13);
        map.addMarker(new MarkerOptions().position(lgaucha).title("Dabeiba").snippet("Antioquia"));
        map.animateCamera(cameraUpdate);



        return v;

    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}

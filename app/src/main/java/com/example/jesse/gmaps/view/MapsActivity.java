package com.example.jesse.gmaps.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.controller.APIController;
import com.example.jesse.gmaps.controller.IntentController;
import com.example.jesse.gmaps.model.Hub;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private IntentController mIntentController; //maybe not needed
    private APIController.HubController mHubController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);  //this represents this "OnMapReadCallback" method - onMapReady()

        mHubController = new APIController.HubController(MapsActivity.this);

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
        mHubController.getHubs();
        // Add a marker in Sydney and move the camera
        LatLng starbucks = new LatLng(49.262239, -123.250248);
        mMap.addMarker(new MarkerOptions().position(starbucks).title("Starbucks @ Kaiser"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(starbucks));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(17));
    }

    public void addMarkers(List<Hub> hubList){
        Log.v("GMAP", hubList.get(1).getName());
        for(Hub hub: hubList){
            double lat = hub.getLatitude();
            double lng = hub.getLongitude();
            LatLng curHubCords = new LatLng(lat,lng);
            mMap.addMarker(new MarkerOptions().position(curHubCords).title(hub.getName()));
            Log.v("GMAP", "Marker added");
        }
    }

    // Add buttons from 'menu.bottom_menu' to toolbar when the activity is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_find:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intent = new Intent(this, HubListActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}

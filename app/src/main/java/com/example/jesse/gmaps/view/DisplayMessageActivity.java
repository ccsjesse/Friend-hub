package com.example.jesse.gmaps.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.controller.IntentController;
import com.example.jesse.gmaps.controller.TabController;

public class DisplayMessageActivity extends AppCompatActivity {

    TabController menuController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        menuController = new TabController(DisplayMessageActivity.this);

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myChildToolbar);
        //get corresponding action bar for this tool bar
        ActionBar ab = getSupportActionBar();
        //enable up button
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();                                            //every activity is started by an intent
        String message  = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);    //get extra stuff from main activity in the intent
        String message2 = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE2);
//        TextView textView =  new TextView(this);                                // create view to display text
//        textView.setTextSize(40);
//        textView.setText("User: " + message + "\n" +"Password: " + message2);
//
//        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message); // R.id only works if the variable in xml has an id
//        layout.addView(textView,1);

        Log.i("MY_MESSAGE", "in onCreate (DisplayMessageActivity)");
    }
    public void goToProfile(View view){
        //do something in response to button
        Intent intent = new Intent(this, ProfileActivity.class); // 1st param activity is subclass of context (refering to LoginActivity) 2nd is refering to the new activity
        startActivity(intent);
    }
    public void goToHubConnect(View view){
        //do something in response to button
        Intent intent = new Intent(this, HubConnectActivity.class); // 1st param activity is subclass of context (refering to LoginActivity) 2nd is refering to the new activity
        startActivity(intent);
    }

    public void goToHubsNearby(View view){
        //do something in response to button
        Intent intent = new Intent(this, MapsActivity.class); // 1st param activity is subclass of context (refering to LoginActivity) 2nd is refering to the new activity
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MY_MESSAGE", "in onResume (DisplayMessageActivity)");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MY_MESSAGE", "in onPause (DisplayMessageActivity)");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MY_MESSAGE", "in onStop (DisplayMessageActivity)");
    }
    // Add buttons from 'menu.appbar' to toolbar when the activity is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                Log.v("Tabs", "Profile Clicked");
                menuController.goToProfile(item);
                return true;

            case R.id.action_settings:
                Log.v("Tabs", "Settings Clicked");
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}

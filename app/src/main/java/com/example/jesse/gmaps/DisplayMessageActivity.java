package com.example.jesse.gmaps;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myChildToolbar);
        //get corresponding action bar for this tool bar
        ActionBar ab = getSupportActionBar();
        //enable up button
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();                                            //every activity is started by an intent
        String message  = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);    //get extra stuff from main activity in the intent
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
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
        Intent intent = new Intent(this, ProfileActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
        startActivity(intent);
    }
    public void goToHubConnect(View view){
        //do something in response to button
        Intent intent = new Intent(this, HubConnectActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
        startActivity(intent);
    }

    public void goToHubsNearby(View view){
        //do something in response to button
        Intent intent = new Intent(this, MapsActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
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
}

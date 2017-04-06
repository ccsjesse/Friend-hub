package com.example.jesse.gmaps.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

<<<<<<< HEAD
=======
import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.controller.APIController;
import com.example.jesse.gmaps.model.Personality;
>>>>>>> eca81c0f1e37de47e280b641f789f326a0dbc59e

public class ProfileActivity extends AppCompatActivity {
    APIController.PersonalityController mPersonalityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar5);
        setSupportActionBar(myChildToolbar);
        //get corresponding action bar for this tool bar
        ActionBar ab = getSupportActionBar();
        //enable up button
        ab.setDisplayHomeAsUpEnabled(true);

        mPersonalityController = new APIController.PersonalityController(ProfileActivity.this);
        mPersonalityController.getPersonalityInfo("1");
    }

    // Add buttons from 'menu.appbar' to toolbar when the activity is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }
    public  static void onPersonalityResponse(Personality personality){
        Log.v("GLOBAL", Personality.userPersonality.getAttrA());    // This shows that Personality.userPersonality... can be used in any function

        personality.getAttrA();
    }
}
package com.example.jesse.gmaps.controller;

import android.app.Activity;
import android.content.Intent;

import com.example.jesse.gmaps.view.DisplayMessageActivity;
import com.example.jesse.gmaps.view.HubConnectActivity;
import com.example.jesse.gmaps.view.MapsActivity;
import com.example.jesse.gmaps.view.ProfileActivity;

import static com.example.jesse.gmaps.view.MainActivity.EXTRA_MESSAGE;
import static com.example.jesse.gmaps.view.MainActivity.EXTRA_MESSAGE2;

/**
 * Created by Srinjoy on 4/5/2017.
 */

public class TabController {
    private  Activity mCurrentActivity;

    public TabController(Activity caller){
        mCurrentActivity = caller;
    }

    public void switchToProfile(){
        Intent intent = new Intent(mCurrentActivity, ProfileActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
        mCurrentActivity.startActivity(intent);
    }
    public void switchToConnect(){
        Intent intent = new Intent(mCurrentActivity, HubConnectActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
        mCurrentActivity.startActivity(intent);
    }
    public void switchToMaps(){
        Intent intent = new Intent(mCurrentActivity, MapsActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
        mCurrentActivity.startActivity(intent);
    }
}

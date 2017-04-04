package com.example.jesse.gmaps.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.jesse.gmaps.view.DisplayMessageActivity;
import com.example.jesse.gmaps.view.LoginActivity;

import static com.example.jesse.gmaps.view.LoginActivity.EXTRA_MESSAGE;
import static com.example.jesse.gmaps.view.LoginActivity.EXTRA_MESSAGE2;

/**
 * Created by Srinjoy on 4/3/2017.
 */

public class IntentController {
    private static Activity mCurrentActvity;

    public IntentController(Activity current){
        mCurrentActvity = current;
    }

    public static void switchToMapsFromLogin(){
        Intent intent = new Intent(mCurrentActvity, DisplayMessageActivity.class); // 1st param activity is subclass of context (refering to LoginActivity) 2nd is refering to the new activity
        intent.putExtra(EXTRA_MESSAGE, "First Message");
        intent.putExtra(EXTRA_MESSAGE2, "Second Message");
        mCurrentActvity.startActivity(intent);
    }


}

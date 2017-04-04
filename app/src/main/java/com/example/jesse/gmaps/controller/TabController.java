package com.example.jesse.gmaps.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.jesse.gmaps.view.DisplayMessageActivity;
import com.example.jesse.gmaps.view.ProfileActivity;

import static com.example.jesse.gmaps.view.LoginActivity.EXTRA_MESSAGE;
import static com.example.jesse.gmaps.view.LoginActivity.EXTRA_MESSAGE2;

/**
 * Created by Srinjoy on 4/4/2017.
 */

public class TabController {
    private static Activity mCurrentActvity;

    public TabController(Activity current){
        mCurrentActvity = current;
    }

    public static void goToProfile(MenuItem item){
        Intent intent = new Intent(mCurrentActvity, ProfileActivity.class); // 1st param activity is subclass of context (refering to LoginActivity) 2nd is refering to the new activity
        mCurrentActvity.startActivity(intent);
    }

}



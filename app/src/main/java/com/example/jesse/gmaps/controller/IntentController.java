package com.example.jesse.gmaps.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.model.User;
import com.example.jesse.gmaps.view.DisplayMessageActivity;
import com.example.jesse.gmaps.view.MainActivity;
import com.example.jesse.gmaps.view.SurveyActivity;

import static com.example.jesse.gmaps.view.MainActivity.EXTRA_MESSAGE;
import static com.example.jesse.gmaps.view.MainActivity.EXTRA_MESSAGE2;

/**
 * Created by Srinjoy on 4/3/2017.
 */

public class IntentController {
    private static Activity mCurrentActvity;

    public IntentController(Activity current){
        mCurrentActvity = current;
    }

    public static void switchToMapsFromLogin(){
        Intent intent = new Intent(mCurrentActvity, DisplayMessageActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is referring to the new activity
        intent.putExtra(EXTRA_MESSAGE, "First Message");
        intent.putExtra(EXTRA_MESSAGE2, "Second Message");
        mCurrentActvity.startActivity(intent);
    }

    public static void switchToSurveyFromLogin(){
        Intent intent = new Intent(mCurrentActvity, SurveyActivity.class);
        mCurrentActvity.startActivity(intent);
    }

    public static void switchFromSurveytoMainActivity(){
        Intent intent = new Intent(mCurrentActvity, MainActivity.class);
        mCurrentActvity.startActivity(intent);
    }

}

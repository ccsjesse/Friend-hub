package com.example.jesse.gmaps.view;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.controller.APIController;
import com.example.jesse.gmaps.controller.IntentController;
import com.example.jesse.gmaps.model.Hub;
import com.example.jesse.gmaps.model.User;

import java.util.List;


public class LoginActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "username";
    public final static String EXTRA_MESSAGE2 = "password";
    private APIController.LoginController mLoginController;
    private IntentController mIntentController;
    private APIController.HubController mHubController;
    private EditText mPasswordView;
    private EditText mEmailView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginController = new APIController.LoginController(LoginActivity.this);
        mIntentController = new IntentController(LoginActivity.this);
        mHubController = new APIController.HubController(LoginActivity.this);

        mPasswordView = (EditText) findViewById(R.id.userPassword);
        mEmailView = (EditText) findViewById(R.id.userEmail);
        // getSupportActionBar().setIcon(getDrawable(R.drawable.actionBarIcon)); //go to gradle scripts build.gradle and change min sdk to 21 then sync now

        Log.i("MY_MESSAGE", "in onCreate (LoginActivity)");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MY_MESSAGE", "in onResume (LoginActivity)");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MY_MESSAGE", "in onPause (LoginActivity)");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("MY_MESSAGE", "in onStop (LoginActivity)");
    }

    public void onLoginResponse(User client){
        if(client.getId() > 0) {
            IntentController.switchToMapsFromLogin(); //Switch contexts here
        }else{
            Toast.makeText(this,"Login Failed", Toast.LENGTH_LONG);
        }
    }
    public void sendMessage(View view){
        //do something in response to button
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        mLoginController.attemptLogin(email,password);
    }

    public void onHubsResponse(List<Hub> hubList){
        Log.v("HUB RESPONSE",hubList.get(1).getName().toString());
    }

    // Add buttons from 'menu.appbar' to toolbar when the activity is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu);
    }


}

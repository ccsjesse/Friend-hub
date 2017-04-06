package com.example.jesse.gmaps.view;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
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


public class MainActivity extends BaseActivity {

    public final static String EXTRA_MESSAGE = "username";
    public final static String EXTRA_MESSAGE2 = "password";
    private APIController.LoginController mLoginController;
    private IntentController mIntentController;
    private APIController.HubController mHubController;
    private EditText mPasswordView;
    private EditText mEmailView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setLayout(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        mLoginController = new APIController.LoginController(MainActivity.this);
        mIntentController = new IntentController(MainActivity.this);
        mHubController = new APIController.HubController(MainActivity.this);

        mPasswordView = (EditText) findViewById(R.id.userPassword);
        mEmailView = (EditText) findViewById(R.id.userEmail);
        // getSupportActionBar().setIcon(getDrawable(R.drawable.actionBarIcon)); //go to gradle scripts build.gradle and change min sdk to 21 then sync now

        Log.i("MY_MESSAGE", "in onCreate (MainActivity)");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MY_MESSAGE", "in onResume (MainActivity)");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("MY_MESSAGE", "in onStop (MainActivity)");
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

    // Add buttons from 'menu.bottom_menu' to toolbar when the activity is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.bottom_menu, menu);
//
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_connect:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.action_profile;
    }
}

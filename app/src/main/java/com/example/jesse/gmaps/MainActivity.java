package com.example.jesse.gmaps;

import android.content.Intent;
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




public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "username";
    public final static String EXTRA_MESSAGE2 = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar =  (Toolbar) findViewById(R.id.my_toolbar1);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Login");
        // getSupportActionBar().setIcon(getDrawable(R.drawable.actionBarIcon)); //go to gradle scripts build.gradle and change min sdk to 21 then sync now
        Log.i("MY_MESSAGE", "in onCreate (MainActivity)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MY_MESSAGE", "in onResume (MainActivity)");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MY_MESSAGE", "in onPause (MainActivity)");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("MY_MESSAGE", "in onStop (MainActivity)");
    }
    public void sendMessage(View view){
        //do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
        EditText editText =(EditText) findViewById(R.id.edit_message);
        EditText editText2 = (EditText) findViewById(R.id.encrypt_message);
        String message = editText.getText().toString();
        String message2 = editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }

    // Add buttons from 'menu.appbar' to toolbar when the activity is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);


        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
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

package com.example.jesse.gmaps.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.view.HubListActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jesse on 3/23/2017.
 */

public class HubInfoTempActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_info_temp);

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myChildToolbar);
        //get corresponding action bar for this tool bar
        ActionBar ab = getSupportActionBar();
        //enable up button
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();                                            //every activity is started by an intent
        String message  = intent.getStringExtra(HubListActivity.HUB_NAME);    //get extra stuff from main activity in the intent
        String message2 = intent.getStringExtra(HubListActivity.HUB_LOCN);
        String message3 = intent.getStringExtra(HubListActivity.HUB_PIC);
        TextView textView =  new TextView(this);                                // create view to display text
        textView.setTextSize(40);
        textView.setText("Name: " + message + "\n" +"Location: " + message2);

        ImageView hubPic = (ImageView) findViewById(R.id.hubPic);
        hubPic.setVisibility (View.VISIBLE);
        new NewAsyncTask(hubPic).execute (message3);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_hub_info_temp); // R.id only works if the variable in xml has an id
        layout.addView(textView,1);

        Log.i("MY_MESSAGE", "in onCreate (DisplayMessageActivity)");
    }

    //This is the asynchronous task. It is extended from Async Task
    class NewAsyncTask extends AsyncTask<String, Integer, Bitmap> {
        // This is the "guts" of the asynchronus task. The code
        // in doInBackground will be execute in a separate thread

        ImageView bmImage;

        public NewAsyncTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

//        @Override
//        protected void onProgressUpdate (Integer... percent_done_array){
//            progress_bar.setProgress(percent_done_array[0]);
//        }

        @Override
        protected Bitmap doInBackground(String... url_array) {
            URL url;
            Log.i("LoginActivity", "Inside the async task");

            try {
//                publishProgress(0);
                url = new URL(url_array[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                publishProgress(25);
                connection.setDoInput(true);
                connection.connect();
//                publishProgress(50);
                Log.i("HubArrayAdaptor", "Successfully opened the web page");

                InputStream input = connection.getInputStream();
//                publishProgress(75);
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                input.close();
//                publishProgress(100);
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        //This routine is called at the end of the task.
        //This routine is run as apart of the main thread, so it can update the GUI.
        //The input parameter is automatically set by the output param of doInBackground

        @Override
        protected void onPostExecute (Bitmap result){
            bmImage.setImageBitmap(result);
        }
    }
}

package com.example.jesse.gmaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by Jesse on 3/21/2017.
 */

public class HubArrayAdaptor extends ArrayAdapter<Hub>  {
    //my new class var, copies of constractor params, but add more if req
    private Context context;
    private ArrayList<Hub> theStringArray;

    // constructor
    public HubArrayAdaptor(Context _context, int textViewResourceId, ArrayList<Hub> _theHubArray){
        //call base class constructor
        super(_context, textViewResourceId, _theHubArray);

        //save the context and the array of hubs we were given
        context = _context;
        theStringArray = _theHubArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate (R.layout.row, parent, false);

//        ImageView icon = (ImageView) row.findViewById(R.id.hubPic);
//        icon.setImageResource(R.drawable.bidoof1);
//        icon.setVisibility (View.VISIBLE);

//        ProgressBar progress_bar;
        ImageView image_view_location = (ImageView) row.findViewById(R.id.icon);
        image_view_location.setVisibility (View.VISIBLE);
        new NewAsyncTask(image_view_location).execute (theStringArray.get(position).getURL()); //URL

        TextView label = (TextView) row.findViewById( R.id.name);
        label.setText (theStringArray.get(position).getName());

        label = (TextView) row.findViewById( R.id.details);
        label.setText (theStringArray.get(position).getLocation());

        return row;
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
            Log.i("MainActivity", "Inside the async task");

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

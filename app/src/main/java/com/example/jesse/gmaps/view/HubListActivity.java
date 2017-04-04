package com.example.jesse.gmaps.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jesse.gmaps.adapters.HubArrayAdaptor;
import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.model.Hub;

import java.util.ArrayList;

/**
 * Created by Jesse on 3/21/2017.
 */

public class HubListActivity extends AppCompatActivity {

    private HubArrayAdaptor hubArrayAdaptor1;
    private ArrayList<Hub> hubArray1 = new ArrayList<Hub>();

    public final static String HUB_NAME = "hubname";
    public final static String HUB_LOCN = "location";
    public final static String HUB_PIC = "hub pic";

    private AdapterView.OnItemClickListener hubClickedHandler = new AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View v, int position, long id){
            //do something
            //do something in response to button
            Hub selectedHub  = (Hub) parent.getAdapter().getItem(position);


            Intent intent = new Intent(v.getContext(), HubInfoTempActivity.class); // 1st param activity is subclass of context (refering to MainActivity) 2nd is refering to the new activity
            String hubName = selectedHub.getName();
            String hubLocation = selectedHub.getLocation();
            String hubPic = selectedHub.getURL();
            intent.putExtra(HUB_NAME, hubName);
            intent.putExtra(HUB_LOCN, hubLocation);
            intent.putExtra(HUB_PIC, hubPic);
            startActivity(intent);
            //position = row number that user touched
        }
    };

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView (R.layout.list_hub);

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myChildToolbar);
        //get corresponding action bar for this tool bar
        ActionBar ab = getSupportActionBar();
        //enable up button
        ab.setDisplayHomeAsUpEnabled(true);

        //create the new adaptors passing important params, such as
        // context, android row style and the array of strings to display
        hubArrayAdaptor1 = new HubArrayAdaptor(this, android.R.layout.simple_list_item_2, hubArray1); // what is simple_list_item_1?

        // get handle to the list view in the Activity main layout
        ListView HubListView = (ListView) findViewById(R.id.listView1);

        // add action listener for when user click on row
        HubListView.setOnItemClickListener(hubClickedHandler);

        //set the adaptor view for both list views above
        HubListView.setAdapter (hubArrayAdaptor1);

        Hub hub1 = new Hub();
        hub1.setName("Starbucks @ Kaiser");
        hub1.setLocation("Location is Kaiser");
        hub1.setImageURL("https://s-media-cache-ak0.pinimg.com/564x/98/3e/e4/983ee49f919eaeb9a299027895b292a1.jpg");

        Hub hub2 = new Hub();
        hub2.setName("hub2");
        hub2.setLocation("hub2 location");
        hub2.setImageURL("https://s-media-cache-ak0.pinimg.com/564x/98/3e/e4/983ee49f919eaeb9a299027895b292a1.jpg");
        //add new details to our com.example.jesse.gmaps.model.Hub array
        hubArray1.add(hub1);
        hubArray1.add(hub2);
        //notify the array adaptor that the arrary contents have changed (redraw)
        hubArrayAdaptor1.notifyDataSetChanged();
    }

}

package com.example.jesse.gmaps;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HubConnectActivity extends AppCompatActivity {

    private BtArrayAdaptor btArrayAdaptor1;
    private ArrayList<String> btArray1 = new ArrayList<String>();

    private AdapterView.OnItemClickListener btClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            //TODO: 1. try to connect to BT hub 2. respond by changing colour of icon
            //do something in response to button
            String selectedBtName = (String) parent.getAdapter().getItem(position);

            //position = row number that user touched
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hub_connect);

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar4);
        setSupportActionBar(myChildToolbar);
        //get corresponding action bar for this tool bar
        ActionBar ab = getSupportActionBar();
        //enable up button
        ab.setDisplayHomeAsUpEnabled(true);

        //create the new adaptors passing important params, such as
        // context, android row style and the array of strings to display
        btArrayAdaptor1 = new BtArrayAdaptor(this, android.R.layout.simple_list_item_2, btArray1); // what is simple_list_item_1?

        // get handle to the list view in the Activity main layout
        ListView HubListView = (ListView) findViewById(R.id.listView1);

        // add action listener for when user click on row
        HubListView.setOnItemClickListener(btClickedHandler);

        //set the adaptor view for list view
        HubListView.setAdapter(btArrayAdaptor1);

        String bt1 = "bluetooth1";
        String bt2 = "bluetooth2";
        //add new details to our com.example.jesse.gmaps.Hub array
        btArray1.add(bt1);
        btArray1.add(bt2);
        //notify the array adaptor that the arrary contents have changed (redraw)
        btArrayAdaptor1.notifyDataSetChanged();
    }
        // Add buttons from 'menu.appbar' to toolbar when the activity is created
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.appbar, menu);
            return true;
        }
}


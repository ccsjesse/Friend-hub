package com.example.jesse.gmaps.view;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.Toast;
import android.Manifest;
import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.adapters.BtArrayAdaptor;

import java.util.ArrayList;
import java.util.Set;

public class HubConnectActivity extends AppCompatActivity {
    private final static int REQUEST_COARSE_LOCATION = 1;

    private BtArrayAdaptor btArrayAdaptor1;
    private ArrayList<String> btArray1 = new ArrayList<String>();
    private BroadcastReceiver mReceiver;
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

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
        setContentView(R.layout.activity_hub_connect);

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

        //See if you have devices that you have paired with
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address

                btArray1.add(deviceName);
                //notify the arrya adaptor that the array contents have changed (redraw)
                btArrayAdaptor1.notifyDataSetChanged();
                Toast toast = Toast.makeText(getApplicationContext(),"in paired devices", Toast.LENGTH_LONG);
                toast.show();
            }
        }
        //NEED ACCESS COARSE LOCATION FOR ACTION_FOUND TO WORK IDK
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_COARSE_LOCATION);


        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast toast2 = Toast.makeText(getApplicationContext(), "onReceived called", Toast.LENGTH_SHORT);
                toast2.show();
                    String action = intent.getAction();
                    if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                        // Discovery has found a device. Get the BluetoothDevice
                        // object and its info from the Intent.
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        String deviceName = device.getName();
                        String deviceHardwareAddress = device.getAddress(); // MAC address
                        //add new details to our btArray
                        btArray1.add(deviceName);
                        //notify the arrya adaptor that the array contents have changed (redraw)
                        btArrayAdaptor1.notifyDataSetChanged();
                        Toast toast1 = Toast.makeText(getApplicationContext(), "in paired devices", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }
        };
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_COARSE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    proceedDiscovery(); // --->
                } else {
                    //TODO re-request
                    Toast toast = Toast.makeText(this,"coarse location is required to detect BT devices", Toast.LENGTH_LONG);
                }
                break;
            }
        }
    }
        protected void proceedDiscovery() {
            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            filter.addAction(BluetoothDevice.ACTION_NAME_CHANGED);
            registerReceiver(mReceiver, filter);

            if(mBluetoothAdapter.isDiscovering())
                mBluetoothAdapter.cancelDiscovery();
            //Look for new devices
            mBluetoothAdapter.startDiscovery();
        }
        // Add buttons from 'menu.appbar' to toolbar when the activity is created
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.appbar, menu);
            return true;
        }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(mReceiver);
    }

}


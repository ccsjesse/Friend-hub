package com.example.jesse.gmaps.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jesse.gmaps.R;
import com.example.jesse.gmaps.controller.TabController;

/**
 * Created by Srinjoy on 4/5/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView navigationView;
    private int mLayoutRes;
    private Activity curActivity;
    private TabController mTabController;

    protected void setLayout(int layoutRes) {
        mLayoutRes = layoutRes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mLayoutRes);

        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        mTabController = new TabController(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    // Remove inter-activity transition to avoid screen tossing on tapping bottom navigation items
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_connect){
            Log.v("NAV", "Action Connect");
            mTabController.switchToConnect();
            return  true;
        }
        if(item.getItemId() == R.id.action_find){
            Log.v("NAV", "Action Find");
            mTabController.switchToMaps();
            return true;
        }
        if(item.getItemId() == R.id.action_profile){
            Log.v("NAV", "Action Profile");
            mTabController.switchToProfile();
            return true;
        }
        else return false;

    }

    private void updateNavigationBarState(){
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    void selectBottomNavigationBarItem(int itemId) {
        Menu menu = navigationView.getMenu();
        for (int i = 0, size = menu.size(); i < size; i++) {
            MenuItem item = menu.getItem(i);
            boolean shouldBeChecked = item.getItemId() == itemId;
            if (shouldBeChecked) {
                item.setChecked(true);
                break;
            }
        }
    }

    abstract int getContentViewId();

    abstract int getNavigationMenuItemId();

}

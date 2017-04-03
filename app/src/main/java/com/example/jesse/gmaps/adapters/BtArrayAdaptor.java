package com.example.jesse.gmaps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesse.gmaps.R;

import java.util.ArrayList;

/**
 * Created by Jesse on 3/28/2017.
 */


public class BtArrayAdaptor extends ArrayAdapter<String> {
    //my new class var, copies of constractor params, but add more if req
    private Context context;
    private ArrayList<String> theStringArray;

    // constructor
    public BtArrayAdaptor(Context _context, int textViewResourceId, ArrayList<String> _theStringArray){
        //call base class constructor
        super(_context, textViewResourceId, _theStringArray);

        //save the context and the array of hubs we were given
        context = _context;
        theStringArray = _theStringArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate (R.layout.row, parent, false);

        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.bidoof1);
        icon.setVisibility (View.VISIBLE);

        TextView label = (TextView) row.findViewById( R.id.name);
        label.setText (theStringArray.get(position));

        return row;
    }
}


package com.example.jesse.gmaps;

/**
 * Created by Jesse on 3/23/2017.
 */

public class Hub {
    String name;
    String location;
    String url;

    public String getName() {return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getURL () { return url;}
    public void setImageURL (String url) {this.url = url; }


    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }



}

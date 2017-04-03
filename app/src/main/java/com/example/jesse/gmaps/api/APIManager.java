package com.example.jesse.gmaps.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Srinjoy on 4/3/2017.
 */

public class APIManager {

    public static final String BASE_SERVER_URL = "https://friend-hub.herokuapp.com";
    public static ServerRoutesCallable service;

    public static ServerRoutesCallable setUpAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_SERVER_URL)
                .build();

        service = retrofit.create(ServerRoutesCallable.class);
        return service;
    }
}

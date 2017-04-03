package com.example.jesse.gmaps.api;

import com.example.jesse.gmaps.model.Personality;
import com.example.jesse.gmaps.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Srinjoy on 4/3/2017.
 */

public interface ServerRoutesCallable {

    //This method is used for "POST"
    @GET("/users/{id}")
    public Call<User> showUser(@Path("id") String id);

    @Headers("Content-type: application/json")
    @POST("/login")
    public Call<User> login(@Body HashMap credentials);

    @GET("/personalities/{id}")
    public Call<Personality> getUserPersonality(@Path("id") String id);

    @PUT("/personalities/1")
    public Call<Personality> submitUserPersonality(@Body HashMap results);

}


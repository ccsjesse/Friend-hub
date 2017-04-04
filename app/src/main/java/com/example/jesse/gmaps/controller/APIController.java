package com.example.jesse.gmaps.controller;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.jesse.gmaps.api.APIManager;
import com.example.jesse.gmaps.api.ServerRoutesCallable;
import com.example.jesse.gmaps.model.User;
import com.example.jesse.gmaps.view.MainActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.jesse.gmaps.api.APIManager.service;

/**
 * Created by Srinjoy on 4/3/2017.
 */

public class APIController {
    private static final String TAG = APIController.class.getSimpleName();
    private static Context mActivityCaller;
    private APIManager mApiManager;
    private ServerRoutesCallable mService;

    public APIController(Activity listener) {
        mActivityCaller = listener;
        mService = APIManager.setUpAPI();
    }
        public static class LoginController extends APIController {

            public LoginController(Activity listener){
                super(listener);
            }

            private User client = new User();

            public void getUserInfo(String id){
                //define which endpoint to call from ServerRoutesCallable methods
                Call<User> call = service.showUser(id);
                //Perform async operation to make HTTP call
                call.enqueue(new Callback<User>() { //Object you are expecting back
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.e(TAG, "Response Body" + response.body());

                        //Set java object based on HTTP response
                        client.setId(response.body().getId());
                        client.setName(response.body().getName());
                        client.setEmail(response.body().getEmail());
                        client.setBio(response.body().getBio());

                        Log.e(TAG, "Client Object" + client);

                        //Call back a method in the original calling Activity
                        ((MainActivity) mActivityCaller).onLoginResponse(client);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e(TAG, "Failed\n" + t.getMessage());
                    }
                });
            }
            //POST with credentials to verify user
            public void attemptLogin(String email, String password){
                HashMap requestObject = new HashMap<String,String>();
                requestObject.put("email", email);
                requestObject.put("password", password);

                Call<User> call = service.login(requestObject);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.body() != null) {
                            client.setId(response.body().getId());
                            client.setName(response.body().getName());
                            client.setEmail(response.body().getEmail());
                            client.setBio(response.body().getBio());
                            Log.e(TAG, "Success" + client);
                            ((MainActivity) mActivityCaller).onLoginResponse(client);
                        }else{ //failed to login
                            Log.v(TAG, "Error" + response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e(TAG, "Failed\n" + t.getMessage());
                    }
                });

            }
        }
    public static class SurveyController extends APIController {

        public SurveyController(Activity listener){
            super(listener);
        }

        private User client = new User(); // change to the model needed

        public void getUserInfo(String id){
            //define which endpoint to call from ServerRoutesCallable methods
            Call<User> call = service.showUser(id);
            //Perform async operation to make HTTP call
            call.enqueue(new Callback<User>() { //Object you are expecting back
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.e(TAG, "Response Body" + response.body());

                    //Set java object based on HTTP response
                    client.setId(response.body().getId());
                    client.setName(response.body().getName());
                    client.setEmail(response.body().getEmail());
                    client.setBio(response.body().getBio());

                    Log.e(TAG, "Client Object" + client);

                    //Call back a method in the original calling Activity
                    ((MainActivity) mActivityCaller).onLoginResponse(client);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e(TAG, "Failed\n" + t.getMessage());
                }
            });
        }
    }
}

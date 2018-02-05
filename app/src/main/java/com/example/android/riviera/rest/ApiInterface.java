package com.example.android.riviera.rest;

import com.example.android.riviera.models.Events;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by thealgo on 2/6/18.
 */

public interface ApiInterface {

    @GET("events/all")
    Call<Events> events();




    @GET("events/names")
    Call<Events> getEventNames();


}
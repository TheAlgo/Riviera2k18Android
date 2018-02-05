package com.example.android.riviera.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thealgo on 2/6/18.
 */

public class Events {

    @SerializedName("events")
    @Expose
    public List<Event> events = new ArrayList<>();
    @SerializedName("success")
    @Expose
    public Boolean success;

}

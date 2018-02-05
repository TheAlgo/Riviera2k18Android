package com.example.android.riviera.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by thealgo on 2/6/18.
 */

public class EventCoordinator extends RealmObject {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("reg_no")
    @Expose
    public String regNo;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("phone")
    @Expose
    public String phone;

}

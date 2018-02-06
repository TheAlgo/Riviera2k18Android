package com.example.android.riviera.Models;

/**
 * Created by thealgo on 2/6/18.
 */

public class DataProvider {
    public DataProvider(int img,String details)
    {

        this.setdetails(details);
        this.setimg(img);

    }
    private int img;
    private String details;
    public void setdetails(String details) {
        this.details = details;
    }

    public String getdetails() {
        return details;
    }




    public int getimg() {
        return img;
    }

    public void setimg(int img) {
        this.img = img;
    }


}




package com.example.android.riviera;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title



        setContentView(R.layout.activity_splash);

       Thread loading = new Thread() {

           public void run() {
               try {
                   sleep(5000);
                   Intent main = new Intent(SplashActivity.this, MainActivity.class);
                   startActivity(main);
               }

             catch (Exception e) {
                       e.printStackTrace();
                   }

                finally {
                       finish();
                   }
               }
           };

        loading.start();
       }

    }

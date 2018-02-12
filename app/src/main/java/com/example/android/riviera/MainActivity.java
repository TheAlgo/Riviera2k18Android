package com.example.android.riviera;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.riviera.fragments.Day1Fragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private boolean isDrawerOpened;
    String choice="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ViewPager vp_pages= (ViewPager) findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter=new FragmentAdapter(getSupportFragmentManager());
        vp_pages.setAdapter(pagerAdapter);

        TabLayout tbl_pages= (TabLayout) findViewById(R.id.tb_pages);
        tbl_pages.setupWithViewPager(vp_pages);


    }

    @Override
    public void onBackPressed() {
      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        if (id == R.id.filter){

            Toast.makeText(getBaseContext(),"Filters are under construction!",Toast.LENGTH_LONG).show();
            return true;
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
//                final View alertView = inflater.inflate(R.layout.filter_dialog,null);
//
//                String[] arraySpinner = new String[] {
//                    "Informals", "Music", "Premium", "Pre-Riviera"
//                };
//                final Spinner s = (Spinner) alertView.findViewById(R.id.category_spinner);
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                        android.R.layout.simple_spinner_item, arraySpinner);
//                adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
//                s.setAdapter(adapter);
//                builder.setView(alertView)
//
//                        .setPositiveButton("Apply", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//
//                                choice = s.getSelectedItem()+"";
//                                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//                                navigationView.setNavigationItemSelectedListener(MainActivity.this);
//
//                                ViewPager vp_pages= (ViewPager) findViewById(R.id.vp_pages);
//                                PagerAdapter pagerAdapter=new FragmentAdapter(getSupportFragmentManager());
//                                vp_pages.setAdapter(pagerAdapter);
//
//                                TabLayout tbl_pages= (TabLayout) findViewById(R.id.tb_pages);
//                                tbl_pages.setupWithViewPager(vp_pages);
//
//
//                            }
//                        })
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//
//                                dialog.dismiss();
//
//                            }
//                        });
//
//            AlertDialog dialog = builder.create();
//            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
//
//            wmlp.gravity = Gravity.BOTTOM | Gravity.CENTER;
//            wmlp.x = 0;   //x position
//            wmlp.y = 0;   //y position
//
//            dialog.show();
//
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_events) {

            // Handle the camera action
        } else if (id == R.id.nav_favourites) {

        } else if (id == R.id.nav_categories) {

        } else if (id == R.id.nav_results) {

        

        }
        else if (id == R.id.nav_about)
        {
            
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    public String getFilter(){
        return choice;
    }


}

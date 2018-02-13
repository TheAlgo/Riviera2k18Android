package com.example.android.riviera.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.riviera.Adapters.DataAdapter;
import com.example.android.riviera.MainActivity;
import com.example.android.riviera.Models.DataProvider;
import com.example.android.riviera.Models.ModelClass;
import com.example.android.riviera.Models.TestingModel;
import com.example.android.riviera.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day1Fragment extends Fragment {

    Context context;
    View v;
    RecyclerView recyclerView1;
    RecyclerView.Adapter adapter1;
    RecyclerView.LayoutManager layoutManager1;
    String [] details;
    int[] Img_Res={R.drawable.ag,R.drawable.bg,R.drawable.cg,R.drawable.eg};
    List<ModelClass> data = new ArrayList<>();
    DataAdapter dataAdapter;
    String filter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("H");
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view1 = inflater.inflate(R.layout.fragment_day1, container, false);
        recyclerView1=(RecyclerView)view1.findViewById(R.id.recycler_data);
        details=getResources().getStringArray(R.array.detailarray);
        int i=0;
        v = view1;

        filter = ((MainActivity)getActivity()).getFilter();

        new AsyncLogin().execute();

        return view1;
    }


    private class AsyncLogin extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            String json = null;
            try {

                InputStream is = context.getAssets().open("day1.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");

            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }

            return json;

        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected void onPostExecute(String result) {

            try {

                JSONArray jArray = new JSONArray(result);

                for(int i=0;i<jArray.length();i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    ModelClass crop = new ModelClass();
                    crop.event_name = json_data.getString("EVENT NAME");
                    crop.club_name = json_data.getString("CLUB NAME");
                    crop.event_coordinator = json_data.getString("PHONE") + "  (" + json_data.getString("COORDINATOR")+")";
                    crop.time = json_data.getString("TIME");
                    crop.venue = json_data.getString("VENUE");
                    if(!filter.equals("")) {
                        if (crop.event_name.equals(filter.toUpperCase()))
                            data.add(crop);
                    }
                    else{
                        data.add(crop);
                    }
                }

                recyclerView1 = (RecyclerView)v.findViewById(R.id.recycler_data);
                dataAdapter = new DataAdapter(data, context);
                recyclerView1.setAdapter(dataAdapter);
                recyclerView1.setLayoutManager(new LinearLayoutManager(context));


            } catch (JSONException e) {
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }

}
package com.example.android.riviera.fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.riviera.Adapters.DataAdapter;
import com.example.android.riviera.Adapters.DataAdapter2;
import com.example.android.riviera.MainActivity;
import com.example.android.riviera.Models.DataProvider;
import com.example.android.riviera.Models.ModelClass;
import com.example.android.riviera.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day2Fragment extends Fragment {
    RecyclerView recyclerView2;
    RecyclerView.Adapter adapter1;
    RecyclerView.LayoutManager layoutManager1;
    String [] details;
    int[] Img_Res={R.drawable.ag,R.drawable.bg,R.drawable.cg,R.drawable.eg};
    List<ModelClass> data2 = new ArrayList<>();
    DataAdapter2 dataAdapter2;
    Context context;
    View v;
    String filter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("H");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view1 = inflater.inflate(R.layout.fragment_day2, container, false);
        recyclerView2=(RecyclerView)view1.findViewById(R.id.recycler_data2);
        details=getResources().getStringArray(R.array.detailarray);
        int i=0;
        v = view1;
        context = getContext();

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

                InputStream is = context.getAssets().open("day2.json");
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
                            data2.add(crop);
                    }
                    else{
                        data2.add(crop);
                    }
                }

                recyclerView2 = (RecyclerView)v.findViewById(R.id.recycler_data2);
                dataAdapter2 = new DataAdapter2(data2, context);
                recyclerView2.setAdapter(dataAdapter2);
                recyclerView2.setLayoutManager(new LinearLayoutManager(context));




            } catch (JSONException e) {
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }


}
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("H");
//        context = getContext();

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

//        for(String name:details)
//        {
//            DataProvider dataprovider=new DataProvider(Img_Res[i],name);
//            arrayList1.add(dataprovider);
//            i++;
//        }
//        adapter1=new DataAdapter(arrayList1);
//        recyclerView1.setHasFixedSize(true);//improve the performance
//        layoutManager1=new LinearLayoutManager(getContext());
//        recyclerView1.setLayoutManager(layoutManager1);
//        recyclerView1.setAdapter(adapter1);

        new AsyncLogin().execute();
        return view1;
    }

    private class AsyncLogin extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            String json = null;
            try {

                InputStream is = context.getAssets().open("music.json");
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


//                Calendar cal=Calendar.getInstance();
//                SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
//                month_name = month_date.format(cal.getTime());

                List<String> kharif = Arrays.asList("July", "August", "September", "October");
                List<String> rabi = Arrays.asList("November", "December", "January", "February");
                List<String> summer = Arrays.asList("March", "April", "May", "June");

//                if(kharif.contains(month_name))
//                    season = "kharif";
//                else if(rabi.contains(month_name))
//                    season = "rabi";
//                else if(summer.contains(month_name))
//                    season = "summer";
//                else
//                    season = "kharif";


                for(int i=0;i<jArray.length();i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    ModelClass crop = new ModelClass();
                    crop.event_name = json_data.getString("remark");
                    crop.club_name = json_data.getString("EMAIL");
                    crop.event_coordinator = json_data.getString("PHONE");
                    //if(crop.crop_state.toLowerCase().equals(state.toLowerCase()) && (crop.crop_season.toLowerCase().equals(season.toLowerCase()) || crop.crop_season.toLowerCase().equals("whole year")))
                    data2.add(crop);
                }

                recyclerView2 = (RecyclerView)v.findViewById(R.id.recycler_data2);
                dataAdapter2 = new DataAdapter2(data2, context);
                recyclerView2.setAdapter(dataAdapter2);
                recyclerView2.setLayoutManager(new LinearLayoutManager(context));
//                recyclerView2.setAdapter(dataAdapter2);
//                recyclerView2.setLayoutManager(new LinearLayoutManager(context));




            } catch (JSONException e) {
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }


}
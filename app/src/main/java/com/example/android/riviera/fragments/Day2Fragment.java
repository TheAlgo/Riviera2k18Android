package com.example.android.riviera.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.riviera.Adapters.DataAdapter;
import com.example.android.riviera.Models.DataProvider;
import com.example.android.riviera.R;

import java.util.ArrayList;


public class Day2Fragment extends Fragment {
    RecyclerView recyclerView1;
    RecyclerView.Adapter adapter1;
    RecyclerView.LayoutManager layoutManager1;
    String [] details;
    int[] Img_Res={R.drawable.ag,R.drawable.bg,R.drawable.cg,R.drawable.eg};
    ArrayList<DataProvider> arrayList1=new ArrayList<DataProvider>();
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
        recyclerView1=(RecyclerView)view1.findViewById(R.id.recycler_data2);
        details=getResources().getStringArray(R.array.detailarray);
        int i=0;
        for(String name:details)
        {
            DataProvider dataprovider=new DataProvider(Img_Res[i],name);
            arrayList1.add(dataprovider);
            i++;
        }
        adapter1=new DataAdapter(arrayList1);
        recyclerView1.setHasFixedSize(true);//improve the performance
        layoutManager1=new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(adapter1);

        return view1;
    }

}
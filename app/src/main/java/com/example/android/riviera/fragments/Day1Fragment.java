package com.example.android.riviera.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.riviera.Adapters.RecyclerAdapter;
import com.example.android.riviera.Models.TestingModel;
import com.example.android.riviera.R;

import java.util.ArrayList;
import java.util.List;


public class Day1Fragment extends Fragment {

    RecyclerView recyclerView;
    List<TestingModel> list= new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_day1, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycle);
        TestingModel model = new TestingModel("ABC");
        list.add(model);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, getActivity().getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }


}

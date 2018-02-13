package com.example.android.riviera.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.riviera.Models.DataProvider;
import com.example.android.riviera.Models.ModelClass;
import com.example.android.riviera.Models.TestingModel;
import com.example.android.riviera.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thealgo on 2/6/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.RecyclerViewHolder> implements Filterable {

    List<ModelClass> list;
    Context context;

    public DataAdapter(List<ModelClass> arrayList2, Context context)
    {

        this.list=arrayList2;
        this.context = context;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_beta,parent,false);
        DataAdapter.RecyclerViewHolder recyclerViewHolder1=new DataAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder1;

    }

    @Override
    public void onBindViewHolder(DataAdapter.RecyclerViewHolder holder1, int position) {
        ModelClass mylist=list.get(position);
        holder1.name.setText(""+mylist.getEvent_name());
        holder1.crop.setText(""+mylist.getEvent_coordinator());
        holder1.clubName.setText(""+mylist.getClub_name());
        holder1.time.setText(""+mylist.getTime());
        holder1.venue.setText(""+mylist.getVenue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView name,time,clubName,crop,venue,cost;

        public RecyclerViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.vname);
            clubName= (TextView) view.findViewById(R.id.vclubName);
            crop = (TextView)view.findViewById(R.id.vCrop);
            time = (TextView)view.findViewById(R.id.vtime);
            venue = (TextView)view.findViewById(R.id.vaddress);
        }
    }
}

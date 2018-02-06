package com.example.android.riviera.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.riviera.Models.ModelClass;
import com.example.android.riviera.R;

import java.util.List;

/**
 * Created by thealgo on 2/6/18.
 */

public class DataAdapter2 extends RecyclerView.Adapter<DataAdapter2.RecyclerViewHolder> {

    List<ModelClass> list;
    Context context;

    public DataAdapter2(List<ModelClass> arrayList2, Context context)
    {

        this.list=arrayList2;
        this.context = context;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_beta,parent,false);
        DataAdapter2.RecyclerViewHolder recyclerViewHolder1=new DataAdapter2.RecyclerViewHolder(view);
        return recyclerViewHolder1;

    }

    @Override
    public void onBindViewHolder(DataAdapter2.RecyclerViewHolder holder1, int position) {
        ModelClass mylist=list.get(position);
        holder1.name.setText("Name : "+mylist.getClub_name());
        holder1.crop.setText(""+mylist.getEvent_coordinator());
        holder1.address.setText("Contact no : "+mylist.getEvent_name());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,address,crop,qty,cost;

        public RecyclerViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.vname);
            address= (TextView) view.findViewById(R.id.vaddress);
            crop = (TextView)view.findViewById(R.id.vCrop);
        }
    }
}

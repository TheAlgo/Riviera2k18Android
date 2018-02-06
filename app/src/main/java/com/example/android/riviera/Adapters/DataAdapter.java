package com.example.android.riviera.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.riviera.Models.DataProvider;
import com.example.android.riviera.R;

import java.util.ArrayList;

/**
 * Created by thealgo on 2/6/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.RecyclerViewHolder> {
    private ArrayList<DataProvider> arrayList1=new ArrayList<>();
    public DataAdapter(ArrayList<DataProvider> arrayList2)
    {
        this.arrayList1=arrayList2;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        DataAdapter.RecyclerViewHolder recyclerViewHolder1=new DataAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder1;

    }

    @Override
    public void onBindViewHolder(DataAdapter.RecyclerViewHolder holder1, int position) {
        DataProvider dataprovider=arrayList1.get(position);
        holder1.imageView.setImageResource(dataprovider.getimg());
        holder1.details.setText(dataprovider.getdetails());




    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView details;

        public RecyclerViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageViewdata);
            details=(TextView)view.findViewById(R.id.textViewdata);


        }
    }
}

package com.example.android.riviera.Adapters;

/**
 * Created by Dell on 06-02-2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.riviera.Models.TestingModel;
import com.example.android.riviera.R;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHoder>{

    List<TestingModel> list;
    Context context;

    public RecyclerAdapter(List<TestingModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card,parent,false);
        MyHoder myHoder = new MyHoder(view);


        return myHoder;
    }

    @Override
    public void onBindViewHolder(MyHoder holder, int position) {
        TestingModel mylist = list.get(position);
        holder.name.setText("Name : "+mylist.getName());
    }

    @Override
    public int getItemCount() {

        int arr = 0;
        try{
            if(list.size()==0){
                arr = 0;
            }
            else{
                arr=list.size();
            }
        }catch (Exception e){
        }
        return arr;
    }

    class MyHoder extends RecyclerView.ViewHolder{
        TextView name;


        public MyHoder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.vname);

        }
    }

}

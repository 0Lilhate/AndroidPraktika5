package com.example.shop_project.Adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.example.shop_project.R;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG  = "RecyclerViewAdapter";
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> name, ArrayList<String> price, ArrayList<String> images){
        this.context = context;
        this.names = name;
        this.prices = price;
        this.images = images;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        ImageView ImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text_view);
            price = itemView.findViewById(R.id.price_text_view);
            ImageView = itemView.findViewById(R.id.image_view);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_first_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder");

        Picasso.with(context).load(images.get(position)).into(holder.ImageView);


        holder.name.setText(names.get(position));
        holder.price.setText(prices.get(position));



    }

    @Override
    public int getItemCount() {
        return names.size();
    }


}

package com.example.shop_project.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shop_project.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.ViewHolder>{

    private static final String TAG = "SaleAdapter";
    private ArrayList<String> SaleNames = new ArrayList<>();
    private ArrayList<String> Sales = new ArrayList<>();
    private ArrayList<String> ImageSales = new ArrayList<>();
    private Context context;

    public SaleAdapter(Context context, ArrayList<String> SaleNames, ArrayList<String> Sales, ArrayList<String> ImageSales){
        this.SaleNames = SaleNames;
        this.Sales = Sales;
        this.ImageSales = ImageSales;
        this.context = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sale_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG,"onBindViewHolder");

        Picasso.with(context).load(ImageSales.get(i)).into(viewHolder.ImageView);


        viewHolder.name.setText(SaleNames.get(i));
        viewHolder.sale.setText(Sales.get(i));


    }

    @Override
    public int getItemCount() {
        return SaleNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView sale;
        ImageView ImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name_sale);
            sale = itemView.findViewById(R.id.tv_sale);
            ImageView = itemView.findViewById(R.id.iv_sale);

        }
    }

}

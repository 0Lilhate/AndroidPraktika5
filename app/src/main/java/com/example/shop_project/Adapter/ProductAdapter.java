package com.example.shop_project.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shop_project.Item.Product;
import com.example.shop_project.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Product> FavoritesProducts = new ArrayList<>();
    Context context;

    public ProductAdapter(Context context, ArrayList<Product> products){
        this.products = products;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_item,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        int position = i;
        Product product = products.get(i);
        myViewHolder.id = product.getId();
        myViewHolder.checkBoxFavorites.setChecked(product.getFavorites());
        myViewHolder.name.setText(product.getName());
        myViewHolder.price.setText(product.getPrice().toString()+"P");

        if(products.get(i).getFavorites()== true){
            FavoritesProducts.add(product);
        }
        else {
            FavoritesProducts.remove(product);
        }


        myViewHolder.checkBoxFavorites.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                products.get(position).setFavorites(b);
                if(b){
                    FavoritesProducts.add(products.get(position));
                }
                else {
                    FavoritesProducts.remove(products.get(position));
                }


            }
        });
    }

    public ArrayList<Product> getFavoritesProducts() {
        return FavoritesProducts;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        CheckBox checkBoxFavorites;
        ImageView image;
        Integer id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxFavorites = itemView.findViewById(R.id.favorites_box);
            name = itemView.findViewById(R.id.textViewName);
            price = itemView.findViewById(R.id.textViewPrice);
            image = itemView.findViewById(R.id.imageViewProduct);

        }
    }
}

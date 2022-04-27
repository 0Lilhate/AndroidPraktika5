package com.example.shop_project.Other;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.shop_project.Adapter.CategoriesAdapter;
import com.example.shop_project.Item.ItemCategories;
import com.example.shop_project.R;

import java.util.ArrayList;

public class CategoriesActivity extends Fragment {
    private View view;
    private Toolbar toolbar;

    private ArrayList<ItemCategories> categories = new ArrayList<>();


    private RecyclerView recyclerViewCategories;
    private RecyclerView.LayoutManager layoutManager;
    private CategoriesAdapter.RecyclerViewClickListener listener;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.categories_layout, container, false);
        setHasOptionsMenu(true);

        toolbar = view.findViewById(R.id.categories_toolbar);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        initItemAdapterForCategories();
        intiAdapterCategories();

        return view;
    }

    private void initItemAdapterForCategories(){
        categories.add(new ItemCategories(1,"Все"));
        categories.add(new ItemCategories(2,"Компьютеры"));
        categories.add(new ItemCategories(3,"Аксессуары"));
        categories.add(new ItemCategories(4,"Смартфоны"));
        categories.add(new ItemCategories(5,"Умные вещи"));
        categories.add(new ItemCategories(6,"Наушники"));
        categories.add(new ItemCategories(7,"Наушники"));
        categories.add(new ItemCategories(8,"Наушники"));
        categories.add(new ItemCategories(9,"Наушники"));
        categories.add(new ItemCategories(10,"Компьютеры"));
        categories.add(new ItemCategories(11,"Аксессуары"));
        categories.add(new ItemCategories(12,"Смартфоны"));
        categories.add(new ItemCategories(13,"Компьютеры"));



    }

    private void intiAdapterCategories(){

        setOnClickListner();
        recyclerViewCategories = view.findViewById(R.id.categories_list);

        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerViewCategories.setLayoutManager(layoutManager);
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getContext(), categories, listener);

        recyclerViewCategories.setAdapter(categoriesAdapter);

    }

    private void setOnClickListner() {
        listener = new CategoriesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), position +"", Toast.LENGTH_SHORT).show();

                


                CategoriesForProduct categoriesForProduct = new CategoriesForProduct();
                //Передача id в CategoriesForProduct
                Bundle bundle = new Bundle();
                bundle.putInt("id",categories.get(position).getId());
                categoriesForProduct.setArguments(bundle);
                //

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment_activity_main2, categoriesForProduct);

                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_back, menu);

        super.onCreateOptionsMenu(menu,inflater);

    }


}

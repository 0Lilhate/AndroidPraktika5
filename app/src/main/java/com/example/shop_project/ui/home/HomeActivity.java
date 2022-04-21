package com.example.shop_project.ui.home;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.shop_project.Adapter.RecyclerViewAdapter;
import com.example.shop_project.Adapter.SaleAdapter;
import com.example.shop_project.Other.CategoriesActivity;
import com.example.shop_project.R;

import java.util.ArrayList;

public class HomeActivity extends Fragment {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView recyclerViewSale;
    View view;
    ImageView appCompatImageView;

    RecyclerView.LayoutManager layoutManager;

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.home_activity,container, false);
        setHasOptionsMenu(true);
        /*toolbar = view.findViewById(R.id.toolbar);
        view.setSupportActionBar(toolbar);*/

        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        init();

        initItemAdapter();
        initRecyclerView();

        addSaleItem();
        initSaleAdapter();

        return view;
    }

    private void init(){
        appCompatImageView = view.findViewById(R.id.iv_categories);
        appCompatImageView.setClickable(true);
        appCompatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoriesActivity categoriesActivity = new CategoriesActivity();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment_activity_main2, categoriesActivity);

                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.my_menu1, menu);

        super.onCreateOptionsMenu(menu,inflater);

    }


    private void initItemAdapter(){
        names.add("Телевизор");
        prices.add("5999");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

        names.add("Iphone 13");
        prices.add("5999");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

        names.add("Ноутбук");
        prices.add("5999");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

        names.add("Яндекс станция");
        prices.add("19 990");
        images.add("https://cache.desktopnexus.com/thumbseg/1549/1549071-bigthumbnail.jpg");

    }

    private void initRecyclerView() {
        recyclerView = view.findViewById(R.id.recycleList);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), names, prices,images);

        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void addSaleItem(){


    }

    private void initSaleAdapter(){
        recyclerViewSale = view.findViewById(R.id.sale_list);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewSale.setLayoutManager(layoutManager);

        /*recyclerViewSale.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
        recyclerViewSale.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));*/

        SaleAdapter saleAdapter = new SaleAdapter(getContext(),names,prices,images);

        recyclerViewSale.setAdapter(saleAdapter);
    }


}
package com.example.shop_project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.shop_project.Item.ItemCategories;
import com.example.shop_project.Other.CategoriesActivity;

import com.example.shop_project.Other.CategoriesForProduct;
import com.example.shop_project.ui.Person.PersonFragment;
import com.example.shop_project.ui.home.HomeActivity;


public class MainActivity extends AppCompatActivity {

    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);*/

        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        HomeActivity homeActivity = new HomeActivity();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.nav_host_fragment_activity_main2, homeActivity);
                        ft.addToBackStack(null);
                        ft.commit();
                        return true;
                    case R.id.navigation_search:
                        return true;
                    case R.id.navigation_shop:
                        return true;
                    case R.id.navigation_person:
                        PersonFragment personFragment = new PersonFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.nav_host_fragment_activity_main2, personFragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        return true;
                }

                return false;
            }
        });



        /*HomeActivity homeActivity = new HomeActivity();
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.nav_host_fragment_activity_main2, homeActivity);
        ft.addToBackStack(null);
        ft.commit();*/




    }

    @Override
    public boolean onNavigateUp() {
        return super.onNavigateUp();
    }



    //Передача данных во фрагмент



}
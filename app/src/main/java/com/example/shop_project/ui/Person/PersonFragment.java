package com.example.shop_project.ui.Person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shop_project.Adapter.PersonCategorAdapter;
import com.example.shop_project.R;

import java.util.ArrayList;


public class PersonFragment extends Fragment {

    View view;
    Toolbar toolbar;
    ArrayList<String> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_person,container, false);
        setHasOptionsMenu(true);

        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        initAdapterForPerson();


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    private void initAdapterForPerson(){
        fillList();
        PersonCategorAdapter personCategorAdapter = new PersonCategorAdapter(getContext(),list);

        ListView listView = view.findViewById(R.id.person_categor_list);
        listView.setAdapter(personCategorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch ((int) l){
                    case 0:
                        break;
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
                Toast.makeText(getContext(), "position = " + i + " id: " + l, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillList(){
        list.add("Заказы");
        list.add("Избранное");
        list.add("Возвраты");
        list.add("Информация об аккаунте");
        list.add("Настройки приватности");
        list.add("Помощь");

    }
}
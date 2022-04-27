package com.example.shop_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shop_project.R;

import java.util.ArrayList;

public class PersonCategorAdapter extends BaseAdapter {
    private ArrayList<String> list = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public PersonCategorAdapter(Context context, ArrayList<String> list){
        this.list = list;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.profile_list_item,viewGroup,false);
        }

        String data = (String) getItem(i);
        TextView textView = view.findViewById(R.id.TV_item_profile);
        textView.setText(data);

        return view;
    }
}

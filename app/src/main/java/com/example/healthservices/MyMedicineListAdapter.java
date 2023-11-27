package com.example.healthservices;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyMedicineListAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] name;
    String[] description;


    public MyMedicineListAdapter(Activity context, String[] name, String[] description, String[] price) {

        super(context, R.layout.activity_buy_medicine,name);
        this.context=context;
        this.name=name;
        this.description=description;
    }
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.medicinelist_items, null,true);

        //wiring widgets
        TextView txtName = rowView.findViewById(R.id.txtMName);
        TextView txtDescription = (TextView) rowView.findViewById
                (R.id.txtMDescription);

        txtName.setText(name[position]);
        txtDescription.setText(description[position]);
        return rowView;

    };
}

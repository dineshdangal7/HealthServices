package com.example.healthservices;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] name;
    String[] address;

    String[] contact;

    String[] fee;
    public MyListAdapter(Activity context, String[] name, String[] address, String[] contact, String[]fee) {

//ArrayAdapter needs String so we are supplying title
        super(context, R.layout.activity_doctor_details,name);
        this.context=context;
        this.name=name;
        this.address=address;
        this.contact=contact;
        this.fee=fee;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_items, null,true);

        //wiring widgets
        TextView txtName = rowView.findViewById(R.id.txtName);
        TextView txtAddress = (TextView) rowView.findViewById
                (R.id.txtAddress);
        TextView txtContact = rowView.findViewById(R.id.txtContact);
        TextView txtFee = rowView.findViewById(R.id.txtFee);

        txtName.setText(name[position]);
        txtAddress.setText(address[position]);
        txtContact.setText(contact[position]);
        txtFee.setText(fee[position]);
        return rowView;
    };
}


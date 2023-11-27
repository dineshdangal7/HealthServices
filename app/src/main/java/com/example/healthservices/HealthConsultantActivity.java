package com.example.healthservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HealthConsultantActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_consultant);

        listView=findViewById(R.id.mylist);
//creating string array
        String names[]=

                {"Om Sai Pathibhara Hospital Pvt.Ltd.-BHADRAPUR CAMPUSMODE-","Birta city Hospital-Birtamode","B&C Medical College Teaching Hospital & Research Center-Birtamode","Om Hospital & Research Center Pvt.Ltd-Kathmandu","Vayodha Hospital-Kathmandu","Jana Sewa Health And Eye Care Hospital-Suryodaya",
                "Nobel International Hospital-Godawari","Nepal Eye Hospital-Kathmandu","Nepal Orthopaedic Hospital-Gokarneshwor",
                "Mechi Eye Hospital-Birtamode","Mechi Zonal Hospital-Bhadrapur","Annapurna Neuro Hospital-Kathmandu"};

//displaying list using ArrayAdapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this,R.layout.listview_items,R.id.text,names);

        listView.setAdapter(adapter);
    }
}
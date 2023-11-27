package com.example.healthservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthInsuranceActivity extends AppCompatActivity {

    private String[][] insurance_details =
            {
                    {"Nepal Life Insurance Company Limited","","","","Click More Details"},
                    {"Nepal Insurance Company Limited","","","","Click More Details"},
                    {"Surya Life Insurance Company Limited","","","","Click More Details"},
                    {"LIC Nepal Limited","","","","Click More Details"},
                    {"Sagarmatha Insurance Company Limited","","","","Click More Details"},

            };
    private int[] images ={
            R.drawable.nepallifeinsurancecompanylimited,
            R.drawable.nepalinsurancecompanylimited,
            R.drawable.suryalifeinsurancecompanylimited,
            R.drawable.licnepallimited,
            R.drawable.sagarmathainsurancecompanylimited,
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    ListView lst;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_insurance);

        lst = findViewById(R.id.imageViewHID);
        btnBack = findViewById(R.id.buttonHIDBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthInsuranceActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<insurance_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", insurance_details[i][0]);
            item.put("line2", insurance_details[i][1]);
            item.put("line3", insurance_details[i][2]);
            item.put("line4", insurance_details[i][3]);
            item.put("line5", insurance_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealthInsuranceActivity.this,HealthInsuranceDetailsActivity.class);
                it.putExtra("text1",insurance_details[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);
            }
        });

    }
}
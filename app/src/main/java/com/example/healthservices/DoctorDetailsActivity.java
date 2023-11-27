package com.example.healthservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    ListView listView;
    // creating arrays
    String[] name=new String[10];
    String[] address=new String[10];

    String[] contact =new String[10];

    String[] fee = new String[1000];

    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_doctor_details);

        tv= findViewById(R.id.textViewHADTitle);
        btn= findViewById(R.id.buttonHADBack);
        listView = findViewById(R.id.mylist);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
               Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
               it.putExtra("text1",title);
               it.putExtra("text2",name[i]);
               it.putExtra("text3",address[i]);
               it.putExtra("text3",contact[i]);
               it.putExtra("text4",fee[i]);
               startActivity(it);
           }
       });



        volleyRequest();

    }

    public void volleyRequest(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //url for localhost
        String url ="http://10.0.2.2/HealthServiceAdmin/admin/doctor/getall.php";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //displaying response string in logcat

                        //Log.d("result",response);
                        getData(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //displaying error response message
                Log.d("exception",error.toString());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    void getData(String res){
        try{
            JSONArray doctors=new JSONArray(res);
            for(int i=0;i<doctors.length();i++){
                JSONObject jobj=doctors.getJSONObject(i);
                String dname=jobj.getString("d_name");
                String daddress=jobj.getString("d_address");
                String dcontact= jobj.getString("d_contact");
                String dfees= jobj.getString("d_fee");
                name[i]=dname;
                address[i]=daddress;
                contact[i]= dcontact;
                fee[i]= dfees;
            }
            //passing arrays to constructor of MyListAdapter
            MyListAdapter adapter = new MyListAdapter(this, name, address , contact , fee);
            listView.setAdapter(adapter);
        }catch (JSONException ex){}
    }

}
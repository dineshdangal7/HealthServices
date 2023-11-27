
package com.example.healthservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    // creating arrays
    String[] name=new String[10];
    String[] description=new String[100];

    String[] price=new String[5000];



    ListView lst;
    Button btnBack,btnGoToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.imageViewHAD);
        btnBack = findViewById(R.id.buttonBMCartBack);
        btnGoToCart = findViewById(R.id.buttonHADBack);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text2",name[i]);
                it.putExtra("text2",description[i]);
                it.putExtra("text3",price[i]);
                startActivity(it);

            }
        });

        volleyRequest();
    }

    public void volleyRequest(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //url for localhost
        String url ="http://10.0.2.2/HealthServiceAdmin/admin/medicine/getall.php";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //displaying response string in logcat

                        Log.d("result",response);
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
                String mname=jobj.getString("m_name");
                String mdescription=jobj.getString("m_description");
                String mprice=jobj.getString("m_price");

                name[i]=mname;
                description[i]=mdescription;
                price[i]=mprice;

            }
            //passing arrays to constructor of MyListAdapter
            MyMedicineListAdapter adapter = new MyMedicineListAdapter(this, name, description,price);
            lst.setAdapter(adapter);
        }catch (JSONException ex){}
    }

}

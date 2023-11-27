package com.example.healthservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class BuyMedicineBookActivity extends AppCompatActivity {
    EditText edname,edaddress,edcontact,edpincode;
    Button btnBooking;
    Button buttonsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname = findViewById(R.id.editTextBMBFullname);
        edaddress = findViewById(R.id.editTextBMBBAddress);
        edcontact = findViewById(R.id.editTextBMBContact);
        edpincode = findViewById(R.id.editTextBMBPincode);
        btnBooking = findViewById(R.id.buttonBMBBooking);
        buttonsend = findViewById(R.id.buttonsend);

        Intent intent=getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        //String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"HealthServices",null,1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removeCart(username,"medicine");
                Toast.makeText(getApplicationContext(), "booking done successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity.class));
            }
        });

        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volleyRequest();
            }
        });
    }

    public void volleyRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2/HealthServiceAdmin/medicineorder/setdata.php";
        String ednameText = edname.getText().toString();
        String edaddressText = edaddress.getText().toString();
        String edpincodeText = edpincode.getText().toString();
        String edcontactText = edcontact.getText().toString();

        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("edname", ednameText);
            jsonParams.put("edaddress", edaddressText);
            jsonParams.put("edpincode", edpincodeText);
            jsonParams.put("edcontact", edcontactText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(BuyMedicineBookActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BuyMedicineBookActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(request);
    }
}
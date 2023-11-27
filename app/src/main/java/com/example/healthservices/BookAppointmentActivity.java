package com.example.healthservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton,btnBook,btnBack;

    Button buttonsend;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoinment);

        tv = findViewById(R.id.textViewBMBPackageName);
        ed1 = findViewById(R.id.editTextBMBFullname);
        ed2 = findViewById(R.id.editTextBMBBAddress);
        ed3 = findViewById(R.id.editTextAppContactNumber);
        ed4 = findViewById(R.id.editTextBMBPincode);
        dateButton = findViewById(R.id.buttonBMCartDate);
        timeButton = findViewById(R.id.buttonCartTime);
        btnBook = findViewById(R.id.buttonBookAppointment);
        btnBack = findViewById(R.id.buttonBMBBooking);
        buttonsend = findViewById(R.id.buttonsend);



        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text1");
        String contact = it.getStringExtra("text3");
        String fees = it.getStringExtra("text4");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons Fees:"+fees+"/-");

        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog.show();
            }
        });

        //timepicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                timePickerDialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointmentActivity.this,FindDoctorActivity.class));
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(getApplicationContext(), "HealthServices", null, 1);
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                if (db.checkAppointmentExists(username, title + " => " + fullname, address, contact, dateButton.getText().toString(), timeButton.getText().toString()) == 1) {
                    Toast.makeText(getApplicationContext(), "Appointment already booked", Toast.LENGTH_LONG).show();
                } else {
                    db.addOrder(username, title + " => " + fullname, address, contact, 0, dateButton.getText().toString(), timeButton.getText().toString(), Float.parseFloat(fees),"appointment");
                    Toast.makeText(getApplicationContext(), "Your appointment is done successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(BookAppointmentActivity.this, HomeActivity.class));
                }
            }
        });

        buttonsend.setOnClickListener(view->{
            volleyRequest();
        });

    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        //int style = AlertDialog.THEME_HOLD_DARK;
        datePickerDialog = new DatePickerDialog(this,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);

    }
    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        //int style = AlertDialog.THEME_HOLD_DARK;
        timePickerDialog = new TimePickerDialog(this,timeSetListener,hrs,mins,true);
    }

    public void volleyRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2/HealthServiceAdmin/doctororder/setdata.php";
        String tvText = tv.getText().toString();
        String ed1Text = ed1.getText().toString();
        String ed3Text = ed3.getText().toString();

        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("tv", tvText);
            jsonParams.put("ed1", ed1Text);
            jsonParams.put("ed3", ed3Text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(BookAppointmentActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BookAppointmentActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(request);
    }
}
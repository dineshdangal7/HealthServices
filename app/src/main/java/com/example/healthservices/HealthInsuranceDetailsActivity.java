package com.example.healthservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthInsuranceDetailsActivity extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button btnBack;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_insurance_details);

        btnBack = findViewById(R.id.buttonHIDBack);
        tv1 = findViewById(R.id.textViewHIDTitle);
        img = findViewById(R.id.imageViewHID);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthInsuranceDetailsActivity.this,HealthInsuranceActivity.class));
            }
        });
    }
}
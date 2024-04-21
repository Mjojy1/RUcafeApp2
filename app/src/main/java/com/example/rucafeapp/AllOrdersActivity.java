package com.example.rucafeapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AllOrdersActivity extends AppCompatActivity {

    Button allOrdersBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allorders);

        allOrdersBack = (Button) findViewById(R.id.allOrdersBack);

        allOrdersBack.setOnClickListener(v -> {
            finish();
        });
    }
}
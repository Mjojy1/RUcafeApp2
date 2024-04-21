package com.example.rucafeapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CurrentOrdersActivity extends AppCompatActivity {

    Button currentOrderBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentorder);

        currentOrderBack = (Button) findViewById(R.id.currentOrderBack);

        currentOrderBack.setOnClickListener(v -> {
            finish();
        });
    }
}
package com.example.rucafeapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SandwichActivity extends AppCompatActivity {

    Button backToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sandwich);

        backToHome = (Button) findViewById(R.id.backToHome);

        backToHome.setOnClickListener(v -> {
            finish();
        });
    }
}
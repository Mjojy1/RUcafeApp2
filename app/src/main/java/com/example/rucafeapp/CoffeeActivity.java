package com.example.rucafeapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CoffeeActivity extends AppCompatActivity {

    Button coffeeBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee);

        coffeeBackToMain = (Button) findViewById(R.id.coffeeBackToMain);

        coffeeBackToMain.setOnClickListener(v -> {
            finish();
        });
    }
}
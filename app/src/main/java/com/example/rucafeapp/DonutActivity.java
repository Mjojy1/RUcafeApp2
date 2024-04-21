package com.example.rucafeapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DonutActivity extends AppCompatActivity {

    Button backToMain;
    ImageView donutImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut);

        donutImage = (ImageView) findViewById(R.id.DonutImage);
        backToMain = (Button) findViewById(R.id.backToMain);

        backToMain.setOnClickListener(v -> {
            finish();
        });
    }
}
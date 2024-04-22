package com.example.rucafeapp;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DonutActivity extends AppCompatActivity {

   // Button backToMain;
   // ImageView donutImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);


        List<Donut> donuts = new ArrayList<Donut>();
        donuts.add(new Donut("jelly",1.79,R.drawable.donut23));





        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),donuts));
    //    donutImage = (ImageView) findViewById(R.id.DonutImage);
     //   backToMain = (Button) findViewById(R.id.backToMain);

    //    backToMain.setOnClickListener(v -> {
    //        finish();
    //    });
    }
}
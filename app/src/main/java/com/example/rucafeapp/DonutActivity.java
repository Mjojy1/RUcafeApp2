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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Donut> donuts = new ArrayList<Donut>();
        donuts.add(new Donut("jelly",1.79,R.drawable.jellyd));
        donuts.add(new Donut("vanilla Frosted",1.79,R.drawable.vanillafrosted));
        donuts.add(new Donut("Chocolate",1.79,R.drawable.chocofrost));
        donuts.add(new Donut("Blueberry Cake",1.79,R.drawable.blueberry));
        donuts.add(new Donut("Double Chocolate",1.79,R.drawable.dobbychoc));
        donuts.add(new Donut("Old Fashion",1.79,R.drawable.oldfashion));
        donuts.add(new Donut("Glazed",1.79,R.drawable.glazed));
        donuts.add(new Donut("Birthday Cake",1.79,R.drawable.birthcake));
        donuts.add(new Donut("Boston Creme",1.79,R.drawable.bostoncreme));
        donuts.add(new Donut("Strawberry Frosted",1.79,R.drawable.strawberryd));
        donuts.add(new Donut("Munchkins",1.79,R.drawable.munchkind));
        donuts.add(new Donut("French Crueller",1.79,R.drawable.frenchcrueller));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),donuts));

    }
}
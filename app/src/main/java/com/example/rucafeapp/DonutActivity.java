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
        donuts.add(new Donut("vanilla Frosted Cake",1.89,R.drawable.vanillafrosted));
        donuts.add(new Donut("Chocolate Cake",1.89,R.drawable.chocofrost));
        donuts.add(new Donut("Blueberry Cake",1.89,R.drawable.blueberry));
        donuts.add(new Donut("Double Chocolate",1.79,R.drawable.dobbychoc));
        donuts.add(new Donut("Old Fashion",1.79,R.drawable.oldfashion));
        donuts.add(new Donut("Glazed Cake",1.89,R.drawable.glazed));
        donuts.add(new Donut("Plain Munchkins",.39,R.drawable.oldfashionmunch));
        donuts.add(new Donut("Boston Creme",1.79,R.drawable.bostoncreme));
        donuts.add(new Donut("Strawberry Frosted",1.79,R.drawable.strawberryd));
        donuts.add(new Donut("Glazed Munchkins",.39,R.drawable.glazedmunch));
        donuts.add(new Donut("Chocolate Munchkins",.39,R.drawable.chocolate_munch));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),donuts));

    }
}
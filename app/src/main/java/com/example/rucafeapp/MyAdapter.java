package com.example.rucafeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Donut> donuts;
    private SelectListener donutListener;

    public MyAdapter(Context context, List<Donut> donuts,SelectListener donutListener) {
        this.context = context;
        this.donuts = donuts;
        this.donutListener = donutListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.donutrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.donutPrice.setText(String.valueOf(donuts.get(position).getPrice()));
        myViewHolder.donutType.setText(donuts.get(position).getFlavor());

        // Check if imageView is null before setting image resource
        if (myViewHolder.imageView != null) {
            myViewHolder.imageView.setImageResource(donuts.get(position).getImage());
        }

        myViewHolder.donutRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donutListener.onItemClick(donuts.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return donuts.size();
    }
}
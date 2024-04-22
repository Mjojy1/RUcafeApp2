package com.example.rucafeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Donut> donuts;

    public MyAdapter(Context context, List<Donut> donuts) {
        this.context = context;
        this.donuts = donuts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.donutrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.donutPrice.setText(String.valueOf(donuts.get(position).getPrice()));
        myViewHolder.donutType.setText(donuts.get(position).getFlavor());
        myViewHolder.imageView.setImageResource(donuts.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return donuts.size();
    }
}
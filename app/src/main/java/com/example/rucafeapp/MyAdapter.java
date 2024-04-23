package com.example.rucafeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Donut> donuts;
    private SelectListener donutListener;

    public MyAdapter(Context context, List<Donut> donuts, SelectListener donutListener) {
        this.context = context;
        this.donuts = donuts;
        this.donutListener = donutListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.donutrecycler, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Donut donut = donuts.get(position);
        holder.donutPrice.setText(String.valueOf(donut.getPrice()));
        holder.donutType.setText(donut.getFlavor());

        if (donut.getImage() != 0) {
            holder.imageView.setImageResource(donut.getImage());
        }

        holder.donutRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donutListener.onItemClick(donut);
            }
        });
    }

    @Override
    public int getItemCount() {
        return donuts.size();
    }
}
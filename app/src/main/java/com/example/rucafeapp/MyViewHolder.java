package com.example.rucafeapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView donutPrice, donutType;
    public RelativeLayout donutRelativeLayout;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        donutType = itemView.findViewById(R.id.donutType);
        donutPrice = itemView.findViewById(R.id.price);
        donutRelativeLayout = itemView.findViewById(R.id.donutRelativeLayout);
    }
}

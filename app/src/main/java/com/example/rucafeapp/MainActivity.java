package com.example.rucafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button toDonut;
    Button toCoffee;
    Button toSandwich;
    Button toCurrentOrder;
    Button toAllOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toDonut = (Button)findViewById(R.id.toDonut);
        toCoffee = (Button)findViewById(R.id.toCoffee);
        toSandwich = (Button)findViewById(R.id.toSandwich);
        toCurrentOrder = (Button)findViewById(R.id.toCurrentOrder);
        toAllOrders = (Button)findViewById(R.id.toAllOrders);


        OrderTracker orderTracker = new OrderTracker();
        orderTracker.run();

        toDonut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, DonutActivity.class));
            }
        });
        toSandwich.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SandwichActivity.class));
            }
        });
        toCoffee.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, CoffeeActivity.class));
            }
        });
        toCurrentOrder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, CurrentOrdersActivity.class));
            }
        });
        toAllOrders.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, AllOrdersActivity.class));
            }
        });
    }

}
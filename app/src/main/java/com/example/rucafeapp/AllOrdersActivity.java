package com.example.rucafeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AllOrdersActivity extends AppCompatActivity {

    Button allOrdersBack;
    Spinner orderNumberSpinner;
    ListView allOrdersListView;
    Button cancelOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allorders);

        allOrdersBack = (Button) findViewById(R.id.allOrdersBack);
        orderNumberSpinner = (Spinner) findViewById(R.id.orderNumberSpinner);
        allOrdersListView = (ListView) findViewById(R.id.allOrdersListView);
        cancelOrder = (Button) findViewById(R.id.cancelOrder);

        ArrayList<Integer> orderNumbers = new ArrayList<>();
        int[] tempNumbers = OrderTracker.getOrderNumbers();
        for(int i = 0; i < tempNumbers.length; i++){
            orderNumbers.add(tempNumbers[i]);
        }
        ArrayAdapter<Integer> orderNumberAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, orderNumbers);
        orderNumberSpinner.setAdapter(orderNumberAdapter);

        orderNumberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Order order = OrderTracker.getOrder((int) parent.getItemAtPosition(position));
                ArrayList<MenuItem> orderItems = new ArrayList<>();
                for(MenuItem item : order.getItems()){
                    orderItems.add(item);
                }
                ArrayAdapter<MenuItem> adapter = new ArrayAdapter<>(AllOrdersActivity.this, android.R.layout.simple_list_item_1, orderItems);
                allOrdersListView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cancelOrder.setOnClickListener(v -> {
            if(orderNumbers.size() == 0 || orderNumberSpinner.getSelectedItem() == null){
                return;
            }
            if(orderNumbers.size() == 1){
                OrderTracker.removeOrder((int) orderNumberSpinner.getSelectedItem());
                orderNumbers.remove((int) orderNumberSpinner.getSelectedItem());
                orderNumberAdapter.notifyDataSetChanged();
                allOrdersListView.setAdapter(null);
                return;
            }
            OrderTracker.removeOrder((int) orderNumberSpinner.getSelectedItem());
            orderNumbers.remove((int) orderNumberSpinner.getSelectedItem());
            orderNumberAdapter.notifyDataSetChanged();
            //set the list view to display the order that is now currently selected by spinner
            Order order = OrderTracker.getOrder((int) orderNumberSpinner.getSelectedItem());
            ArrayList<MenuItem> orderItems = new ArrayList<>();
            for(MenuItem item : order.getItems()){
                orderItems.add(item);
            }
            ArrayAdapter<MenuItem> adapter = new ArrayAdapter<>(AllOrdersActivity.this, android.R.layout.simple_list_item_1, orderItems);
            allOrdersListView.setAdapter(adapter);
        });

        allOrdersBack.setOnClickListener(v -> {
            finish();
        });
    }
}
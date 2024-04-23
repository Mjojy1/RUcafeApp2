package com.example.rucafeapp;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class CurrentOrdersActivity extends AppCompatActivity {

    MenuItem removeItemTracker;
    Button currentOrderBack;
    ListView currentOrderList;
    TextInputEditText totalAmountInput;
    TextInputEditText subTotalInput;
    TextInputEditText salesTaxInput;
    Button removeItem;
    Button placeOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentorder);

        Order order = OrderTracker.getCurrentOrder();

        currentOrderBack = findViewById(R.id.currentOrderBack);
        currentOrderList = findViewById(R.id.currentOrderList);
        totalAmountInput = findViewById(R.id.totalAmountInput);
        subTotalInput = findViewById(R.id.subTotalInput);
        salesTaxInput = findViewById(R.id.salesTaxInput);
        removeItem = findViewById(R.id.removeItem);
        placeOrder = findViewById(R.id.placeOrder);

        double tempTax = OrderTracker.getCurrentOrder().calculateTotal() * 0.06625;
        double grandtotal = OrderTracker.getCurrentOrder().calculateTotal() + tempTax;

        totalAmountInput.setText(String.format("%.2f", grandtotal));
        subTotalInput.setText(String.format("%.2f", OrderTracker.getCurrentOrder().calculateTotal()));
        salesTaxInput.setText(String.format("%.2f", tempTax));

        ArrayList<MenuItem> orderItems = new ArrayList<>();
        if (order.getItems() != null) {
            for (MenuItem item : order.getItems()) {
                orderItems.add(item);
            }
        }

        ArrayAdapter<MenuItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderItems);
        currentOrderList.setAdapter(adapter);

        currentOrderList.setOnItemClickListener((parent, view, position, id) -> {
            removeItemTracker = (MenuItem) parent.getItemAtPosition(position);
        });

        currentOrderBack.setOnClickListener(v -> {
            finish();
        });

        removeItem.setOnClickListener(v -> {
            if (removeItemTracker != null) {
                OrderTracker.removeItem(removeItemTracker);
                adapter.remove(removeItemTracker);
                adapter.notifyDataSetChanged();
                totalAmountInput.setText(String.format("%.2f", OrderTracker.getCurrentOrder().calculateGrandTotal()));
                subTotalInput.setText(String.format("%.2f", OrderTracker.getCurrentOrder().calculateTotal()));
                salesTaxInput.setText(String.format("%.2f", OrderTracker.getCurrentOrder().calculateTotal() * 0.06625));
            }
        });

        placeOrder.setOnClickListener(v -> {
            if(OrderTracker.getCurrentOrder().getItems().length == 0){
                Toast toast = Toast.makeText(getApplicationContext(), "No items in order", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            OrderTracker.placeOrder();
            adapter.clear();
            adapter.notifyDataSetChanged();
            totalAmountInput.setText("0.00");
            subTotalInput.setText("0.00");
            salesTaxInput.setText("0.00");
        });
    }
}
package com.example.rucafeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class CoffeeActivity extends AppCompatActivity {

    Button coffeeBackToMain;
    TextInputEditText coffeeTotal;
    Button addCoffee;
    CheckBox irishCreamCheckBox;
    CheckBox caramelCheckBox;
    CheckBox sweetCreamCheckBox;
    CheckBox mochaCheckBox;
    CheckBox frenchVanillaCheckBox;
    Spinner sizeSpinner;
    Spinner quantitySpinner;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee);

        coffeeBackToMain = (Button) findViewById(R.id.coffeeBackToMain);
        coffeeTotal = (TextInputEditText) findViewById(R.id.coffeeTotal);
        addCoffee = (Button) findViewById(R.id.addCoffee);
        irishCreamCheckBox = (CheckBox) findViewById(R.id.irishCreamCheckBox);
        caramelCheckBox = (CheckBox) findViewById(R.id.caramelCheckBox);
        sweetCreamCheckBox = (CheckBox) findViewById(R.id.sweetCreamCheckBox);
        mochaCheckBox = (CheckBox) findViewById(R.id.mochaCheckBox);
        frenchVanillaCheckBox = (CheckBox) findViewById(R.id.frenchVanillaCheckBox);
        sizeSpinner = (Spinner) findViewById(R.id.sizeSpinner);
        quantitySpinner = (Spinner) findViewById(R.id.quantitySpinner);

        ArrayList<String> sizes = new ArrayList<>();
        sizes.add("Short");
        sizes.add("Tall");
        sizes.add("Grande");
        sizes.add("Venti");
        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sizes);
        sizeSpinner.setAdapter(sizeAdapter);
        ArrayList<String> quantities = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            quantities.add(Integer.toString(i));
        }
        ArrayAdapter<String> quantityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, quantities);
        quantitySpinner.setAdapter(quantityAdapter);

        coffeeBackToMain.setOnClickListener(v -> {
            finish();
        });

        addCoffee.setOnClickListener(v -> {
            String size = sizeSpinner.getSelectedItem().toString();
            for(int i = 0; i < quantitySpinner.getSelectedItemPosition(); i++){
                OrderTracker.addCoffee(size, getAddOns(), subTotal());
            }
        });

        irishCreamCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            coffeeTotal.setText(String.format("$%.2f", subTotal()));
        });
        caramelCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            coffeeTotal.setText(String.format("$%.2f", subTotal()));
        });
        sweetCreamCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            coffeeTotal.setText(String.format("$%.2f", subTotal()));
        });
        mochaCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            coffeeTotal.setText(String.format("$%.2f", subTotal()));
        });
        frenchVanillaCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            coffeeTotal.setText(String.format("$%.2f", subTotal()));
        });

        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                coffeeTotal.setText(String.format("$%.2f", subTotal()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                coffeeTotal.setText(String.format("$%.2f", subTotal()));
            }
        });
        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                coffeeTotal.setText(String.format("$%.2f", subTotal()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                coffeeTotal.setText(String.format("$%.2f", subTotal()));
            }
        });
    }
    private String getsize(){
        return sizeSpinner.getSelectedItem().toString();
    }
    private double subTotal(){
        double price = 0;
        price += addOnPrice();
        price += sizePrice(sizeSpinner.getSelectedItem().toString());
        price *= Integer.parseInt(quantitySpinner.getSelectedItem().toString());
        return price;
    }
    private double addOnPrice(){
        double price = 0;
        if(irishCreamCheckBox.isChecked()){
            price += 0.50;
        }
        if(caramelCheckBox.isChecked()){
            price += 0.50;
        }
        if(sweetCreamCheckBox.isChecked()){
            price += 0.50;
        }
        if(mochaCheckBox.isChecked()){
            price += 0.50;
        }
        if(frenchVanillaCheckBox.isChecked()){
            price += 0.50;
        }
        return price;
    }
    private double sizePrice(String size){
        if(size.equals("Short")){
            return 1.99;
        }
        else if(size.equals("Tall")){
            return 2.49;
        }
        else if(size.equals("Grande")){
            return 2.99;
        }
        else{
            return 3.49;
        }
    }
    private String[] getAddOns(){
        String[] addOns = new String[5];
        int i = 0;
        if(irishCreamCheckBox.isChecked()){
            addOns[i] = "Irish Cream";
            i++;
        }
        if(caramelCheckBox.isChecked()){
            addOns[i] = "Caramel";
            i++;
        }
        if(sweetCreamCheckBox.isChecked()){
            addOns[i] = "Sweet Cream";
            i++;
        }
        if(mochaCheckBox.isChecked()){
            addOns[i] = "Mocha";
            i++;
        }
        if(frenchVanillaCheckBox.isChecked()){
            addOns[i] = "French Vanilla";
            i++;
        }
        return addOns;
    }
}
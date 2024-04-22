package com.example.rucafeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SandwichActivity extends AppCompatActivity {

    Button backToHome;
    TextInputEditText sandwichTotal;
    Button addSandwich;
    RadioButton bagelType;
    RadioButton wheatType;
    RadioButton sourType;
    RadioButton beefType;
    RadioButton chickenType;
    RadioButton fishType;
    RadioGroup breadGroup;
    RadioGroup meatGroup;
    CheckBox lettuceAddOn;
    CheckBox tomatoAddOn;
    CheckBox onionAddOn;
    CheckBox cheeseAddOn;
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sandwich);

        backToHome = (Button) findViewById(R.id.backToHome);
        sandwichTotal = (TextInputEditText) findViewById(R.id.sandwichTotal);
        addSandwich = (Button) findViewById(R.id.addSandwich);
        bagelType = (RadioButton) findViewById(R.id.bagelType);
        wheatType = (RadioButton) findViewById(R.id.wheatType);
        sourType = (RadioButton) findViewById(R.id.sourType);
        beefType = (RadioButton) findViewById(R.id.beefType);
        chickenType = (RadioButton) findViewById(R.id.chickenType);
        fishType = (RadioButton) findViewById(R.id.fishType);
        breadGroup = (RadioGroup) findViewById(R.id.breadGroup);
        meatGroup = (RadioGroup) findViewById(R.id.meatGroup);
        lettuceAddOn = (CheckBox) findViewById(R.id.lettuceAddOn);
        tomatoAddOn = (CheckBox) findViewById(R.id.tomatoAddOn);
        onionAddOn = (CheckBox) findViewById(R.id.onionAddOn);
        cheeseAddOn = (CheckBox) findViewById(R.id.cheeseAddOn);

        backToHome.setOnClickListener(v -> {
            finish();
        });

        addSandwich.setOnClickListener(v -> {
            if(breadGroup.getCheckedRadioButtonId() == -1 || meatGroup.getCheckedRadioButtonId() == -1){
                Toast toast = Toast.makeText(getApplicationContext(), "Please select a bread and protein", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            double price = 0;
            String sandwichType = "";
            price += proteinPrice();

            OrderTracker.addSandwich(getBread(), getProtein(), getAddOns(), price);
            Toast toast = Toast.makeText(getApplicationContext(), "Sandwich added to order", Toast.LENGTH_SHORT);
            toast.show();
        });

        meatGroup.setOnCheckedChangeListener((group, checkedId) -> {
            sandwichTotal.setText(String.format("%.2f", subTotal()));
        });

        lettuceAddOn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sandwichTotal.setText(String.format("%.2f", subTotal()));
        });

        tomatoAddOn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sandwichTotal.setText(String.format("%.2f", subTotal()));
        });

        onionAddOn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sandwichTotal.setText(String.format("%.2f", subTotal()));
        });

        cheeseAddOn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sandwichTotal.setText(String.format("%.2f", subTotal()));
        });
    }
    private double subTotal(){
        double price = 0;
        price += proteinPrice();
        price += addOnPrice();
        return price;
    }
    private double addOnPrice(){
        double price = 0;
        if(lettuceAddOn.isChecked()){
            price += 0.3;
        }
        if(tomatoAddOn.isChecked()){
            price += 0.3;
        }
        if(onionAddOn.isChecked()){
            price += 0.3;
        }
        if(cheeseAddOn.isChecked()){
            price += 1.0;
        }
        return price;
    }
    private String getProtein(){
        String protein = "";
        if(beefType.isChecked()){
            protein = "Beef";
        }
        else if(chickenType.isChecked()){
            protein = "Chicken";
        }
        else if(fishType.isChecked()){
            protein = "Fish";
        }
        return protein;
    }
    private String getBread(){
        String bread = "";
        if(bagelType.isChecked()){
            bread = "Bagel";
        }
        else if(wheatType.isChecked()){
            bread = "Wheat";
        }
        else if(sourType.isChecked()){
            bread = "Sour";
        }
        return bread;
    }
    private double proteinPrice(){
        double price = 0;
        if(beefType.isChecked()){
            price = 10.99;
        }
        else if(chickenType.isChecked()){
            price = 9.99;
        }
        else if(fishType.isChecked()){
            price = 8.99;
        }
        return price;
    }
    private String[] getAddOns(){
        String[] addOns = new String[4];
        int i = 0;
        if(lettuceAddOn.isChecked()){
            addOns[i] = "Lettuce";
            i++;
        }
        if(tomatoAddOn.isChecked()){
            addOns[i] = "Tomato";
            i++;
        }
        if(onionAddOn.isChecked()){
            addOns[i] = "Onion";
            i++;
        }
        if(cheeseAddOn.isChecked()){
            addOns[i] = "Cheese";
            i++;
        }
        return addOns;
    }
}
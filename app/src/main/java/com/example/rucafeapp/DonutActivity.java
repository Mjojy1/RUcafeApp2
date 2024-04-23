package com.example.rucafeapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DonutActivity extends AppCompatActivity implements SelectListener {

    public Donut mainDonut;
    private RecyclerView recyclerView;
    private ListView listView;
    public ArrayList<Donut> donutArrayList = new ArrayList<Donut>();
    private ArrayList<Donut> selectedDonutsList = new ArrayList<>();
    private Button add;
    private Button remove;
    private Spinner quantOfDonuts;
    private Button addDonutOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.donut);
        recyclerView = findViewById(R.id.donutList);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.coffeeSize), (v, insets) -> {
            Insets systemBars = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()).toPlatformInsets();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            }
            return insets;
        });


        Button homeView = findViewById(R.id.homeScr);
        listView = findViewById(R.id.donutListView);
        add = findViewById(R.id.addDonutsToListView);
        remove = findViewById(R.id.removeDonutsFromListView);
        quantOfDonuts = findViewById(R.id.quantOfDonuts);
        addDonutOrder = findViewById(R.id.addDonutOrder);


        add.setOnClickListener(v -> addToDonutAL());
        remove.setOnClickListener(v -> removeFromDonutAL());

        homeView.setOnClickListener(v -> {
            Intent home = new Intent(DonutActivity.this, MainActivity.class);
            startActivity(home);
        });

        String[] arraySpin = new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
        };
        Spinner s = findViewById(R.id.quantOfDonuts);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        RecyclerView recyclerView = findViewById(R.id.donutList);

        List<Donut> donuts = new ArrayList<>();
        donuts.add(new Donut("jelly", 1.79, R.drawable.firstimg));
        donuts.add(new Donut("vanilla Frosted Cake", 1.89, R.drawable.secondimg));
        donuts.add(new Donut("Chocolate Cake", 1.89, R.drawable.thirdimg));
        donuts.add(new Donut("Blueberry Cake", 1.89, R.drawable.fourthimg));
        donuts.add(new Donut("Double Chocolate", 1.79, R.drawable.fifthimg));
        donuts.add(new Donut("Old Fashion", 1.79, R.drawable.sixthimg));
        donuts.add(new Donut("Glazed Cake", 1.89, R.drawable.seventhimg));
        donuts.add(new Donut("Plain Munchkins", .39, R.drawable.eightimg));
        donuts.add(new Donut("Bostvon Creme", 1.79, R.drawable.ninthimg));
        donuts.add(new Donut("Strawberry Frosted", 1.79, R.drawable.tenthimg));
        donuts.add(new Donut("Glazed Munchkins", .39, R.drawable.eleventhimg));
        donuts.add(new Donut("Chocolate Munchkins", .39, R.drawable.twelthimg));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), donuts, (SelectListener) this));

        addDonutOrder.setOnClickListener(v -> {
            AddDonutOrder();
        });
    }

    @Override
    public void onItemClick(Donut donut) {
        Toast.makeText(this, "Clicked Donut Flavor" + donut.getFlavor() + ",Price: " + donut.getPrice(), Toast.LENGTH_SHORT).show();
        mainDonut = donut;
    }

    private void AddDonutOrder() {
        selectedDonutsList.clear();

        for (Donut donut : donutArrayList) {
            OrderTracker.addDonut(donut.getFlavor(), donut.getPrice());
        }

        Toast.makeText(this, "Added " + donutArrayList.size() + " donut(s) to the order", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void addToDonutAL() {
        if (mainDonut == null) {
            return;
        }

        int quantity = Integer.parseInt((String) quantOfDonuts.getSelectedItem());
        for (int i = 0; i < quantity; i++) {
            Donut donutToAdd = new Donut(mainDonut.getFlavor(), mainDonut.getPrice(), mainDonut.getImage());
            donutArrayList.add(donutToAdd);
        }
        updateListView();
    }

    public void removeFromDonutAL() {
        int x = Integer.parseInt((String) quantOfDonuts.getSelectedItem());
        int removedCount = 0;

        if (mainDonut != null) {
            for (int i = donutArrayList.size() - 1; i >= 0; i--) {
                Donut currentDonut = donutArrayList.get(i);
                if (mainDonut.getFlavor().equals(currentDonut.getFlavor()) &&
                        mainDonut.getPrice().equals(currentDonut.getPrice())) {
                    donutArrayList.remove(i);
                    removedCount++;
                    if (removedCount == x) {
                        break;
                    }
                }
            }

            // Notify the adapter that data set has changed
            Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
            updateListView(); // Call updateListView after notifyDataSetChanged
        } else {
            Toast.makeText(this, "Please select a donut to remove", Toast.LENGTH_SHORT).show();
        }
    }




    private void updateListView() {
        ArrayAdapter<Donut> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, donutArrayList);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
package com.example.healthservices;
import androidx.appcompat.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    private GridView gridView;
    private GridAdapter gridAdapter;
    private ArrayList<GridItem> allItems;
    private ArrayList<GridItem> filteredItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        gridView = findViewById(R.id.gridViewed);

        // Initialize allItems with your data
        allItems = new ArrayList<>(); // Initialize the ArrayList here
        allItems.add(new GridItem(R.drawable.home, "LAB TEST", LabTestActivity.class));
        allItems.add(new GridItem(R.drawable.language, "BUY MEDICINE", BuyMedicineActivity.class));
        allItems.add(new GridItem(R.drawable.chat, "FIND DOCTOR", FindDoctorActivity.class));
        allItems.add(new GridItem(R.drawable.calendar, "HEALTH ARTICLE", HealthArticlesActivity.class));
        allItems.add(new GridItem(R.drawable.widgets, "ORDER DETAILS", OrderDetailsActivity.class));
        allItems.add(new GridItem(R.drawable.ic_baseline_phone_call, "CONSULTATION", HealthConsultantActivity.class));
        allItems.add(new GridItem(R.drawable.ic_baseline_insurance, "INSURANCE", HealthInsuranceActivity.class));
        allItems.add(new GridItem(R.drawable.info, "LOGOUT", LoginActivity.class));
        // Add more items...

        filteredItems = new ArrayList<>(allItems);

        gridAdapter = new GridAdapter(this, filteredItems);
        gridView.setAdapter(gridAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle query submission if needed
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the items based on the search query
                filterItems(newText);
                return true;
            }
        });

        return true;
    }
    private void filterItems(String query) {
        filteredItems.clear();

        if (query.isEmpty()) {
            filteredItems.addAll(allItems);
        } else {
            for (GridItem item : allItems) {
                if (item.getItemName().toLowerCase().contains(query.toLowerCase())) {
                    filteredItems.add(item);
                }
            }
        }

        gridAdapter.notifyDataSetChanged();
    }
}


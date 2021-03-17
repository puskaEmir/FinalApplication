package com.academy.finalacademy387;

import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.academy.finalacademy387.bmi.BmiActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * <li>1. row.xml -> dizajnirali smo izgled jednog item unutar RecyclerView</li>
 * <li>2. RowModel -> mnoštvo objekata </li>
 * <li>3. MyViewHolder extends RecyclerView.ViewHolder</li>
 * <li>4. MyAdapter extends RecyclerView.Adapter<MyViewHolder></li>
 *
 * <p></p>
 *  HttpUrlConnection
 *
 *  HttpsURLConnection
 *
 *  URL url = new Url("httt://foog.....")
 *  HttpUrlConnection connection = url.openConnection();
 * <li></li>
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        navigationView = findViewById(R.id.navigationView);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        toggle.syncState();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(this, loadRowModelList());
        recyclerView.setAdapter(adapter);
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bmiNavigationItem:
                Intent intent = new Intent(this, BmiActivity.class);
                startActivity(intent);
                break;
            case R.id.books:

                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private List<RowModel> loadRowModelList() {
        List<RowModel> rowModels = new ArrayList<>();

        RowModel bmiCalculator = new RowModel();

        bmiCalculator.setTitle(getResources().getString(R.string.bmiCalculator));
        bmiCalculator.setDescription("Body Mass Index calculator je dobar indikator vašeg zdravlja...");
        bmiCalculator.setImageResourceId(R.drawable.bmi);
        rowModels.add(bmiCalculator);

        RowModel calculator = new RowModel();
        calculator.setTitle("Calculator");
        calculator.setDescription("Kalkulator osnovnih matematskih operacija specijalno dizajniran za vas...");
        calculator.setImageResourceId(R.drawable.calculator);
        rowModels.add(calculator);


        RowModel hairDyeItem = new RowModel();
        hairDyeItem.setTitle("Hair Dye");
        hairDyeItem.setDescription("Kalkulator osnovnih matematskih operacija specijalno dizajniran za vas...");
        hairDyeItem.setImageResourceId(R.drawable.hair_dye);
        rowModels.add(hairDyeItem);

        RowModel calculator2 = new RowModel();
        calculator2.setTitle("Calculator");
        calculator2.setDescription("Kalkulator osnovnih matematskih operacija specijalno dizajniran za vas...");
        calculator2.setImageResourceId(R.drawable.calculator);
        rowModels.add(calculator2);

        RowModel calculator3 = new RowModel();
        calculator3.setTitle("Calculator");
        calculator3.setDescription("Kalkulator osnovnih matematskih operacija specijalno dizajniran za vas...");
        calculator3.setImageResourceId(R.drawable.calculator);
        rowModels.add(calculator3);

        RowModel calculator4 = new RowModel();
        calculator4.setTitle("Calculator");
        calculator4.setDescription("Kalkulator osnovnih matematskih operacija specijalno dizajniran za vas...");
        calculator4.setImageResourceId(R.drawable.ic_launcher_background);
        rowModels.add(calculator);
        return rowModels;
    }
}
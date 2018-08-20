package com.dakakolp.app1train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dakakolp.app1train.addedclass.Country;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CountryAdapter countryAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_countries);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Country> countries = new ArrayList<Country>();
        countries.add(new Country(R.drawable.if_algeria, "Algeria", "Algeria",40.61));
        countries.add(new Country(R.drawable.if_benin, "Benin", "Porto-Novo",10.56));
        countries.add(new Country(R.drawable.if_south_korea, "South Korea", "Seoul",51.25));
        countries.add(new Country(R.drawable.if_monaco, "Monaco", "Monaco",0.39));
        countries.add(new Country(R.drawable.if_armenia, "Armenia", "Yerevan",2.93));
        countries.add(new Country(R.drawable.if_belgium, "Belgium", "Brussels",11.35));

        countryAdapter = new CountryAdapter(countries);
        recyclerView.setAdapter(countryAdapter);
    }
}

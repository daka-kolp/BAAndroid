package com.dakakolp.applicationtask5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnInfoClickListener {

    List<Info> infoList;
    RecyclerView recyclerView;
    InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        infoList = new ArrayList<>();

        infoList.add(new Info(R.drawable.if_face1, "Text"));
        infoList.add(new Info(R.drawable.if_face2, "Text"));
        infoList.add(new Info(R.drawable.if_face3, "Text"));
        infoList.add(new Info(R.drawable.if_face4, "Text"));
        infoList.add(new Info(R.drawable.if_face4, "Text"));
        infoList.add(new Info(R.drawable.if_face5, "Text"));

        infoAdapter = new InfoAdapter(infoList, this);
        recyclerView.setAdapter(infoAdapter);
    }

    @Override
    public void onInfoClick(int position) {
        Toast.makeText(this, "Item clicked " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNewInfoClick(int position) {
        infoList.remove(position);
        infoAdapter.notifyDataSetChanged();

    }
}

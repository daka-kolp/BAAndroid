package com.dakakolp.apptask7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ColorActivity extends AppCompatActivity {
    public static final String ID_COLOR = "IDColor";
    public static final String NAME_COLOR = "NameColor";

    private RecyclerView recyclerView;
    private List<ColorRes> colorResList;
    private ColorAdapter colorAdapter;
    private OnColorClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        colorResList = ColorRes.createList();

        recyclerView = findViewById(R.id.recyclerview_for_coloractivity);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listener = new OnColorClickListener() {
            @Override
            public void onColorClick(int position) {
                Intent intent = new Intent(ColorActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(ID_COLOR, colorResList.get(position).getResourceColor());
                bundle.putString(NAME_COLOR, colorResList.get(position).getResourceName());
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();

            }
        };

        colorAdapter = new ColorAdapter(listener, colorResList);

        recyclerView.setAdapter(colorAdapter);
    }
}

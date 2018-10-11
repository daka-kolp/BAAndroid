package com.brainacad.apptask14;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private List<Uri> uris;

    public static final int CODE_GALLERY = 103;

    private MyListener listener = new MyListener() {
        @Override

        public void onOpenClick(int pos) {
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);

            MainActivity.this.startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    CODE_GALLERY);
        } else {
            uris = getAllItems();
            imageAdapter = new ImageAdapter(uris);
            imageAdapter.setListener(listener);
            recyclerView.setAdapter(imageAdapter);
        }


    }


    private List<Uri> getAllItems() {

        List<Uri> uris = new ArrayList<Uri>();

        String[] list = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
                list,
                null,
                null,
                MediaStore.Images.Thumbnails._ID); //Thumbnails - миниатюрные копии
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String data = cursor.getString(1);
                Uri imagesUri = Uri.parse(data);
                uris.add(imagesUri);
            }
        }
        cursor.close();
        return uris;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CODE_GALLERY:
                if (grantResults.length == 1) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        uris = getAllItems();
                        imageAdapter = new ImageAdapter(uris);
                        imageAdapter.setListener(listener);
                        recyclerView.setAdapter(imageAdapter);
                        Toast.makeText(this, "Now have access to view trumbs", Toast.LENGTH_SHORT).show();
                    }
                }
                break;


        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}

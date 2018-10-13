package com.brainacad.apptask14;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private List<ItemImage> uris;

    public static final int CODE_GALLERY = 103;

    private MyListener listener = new MyListener() {
        @Override

        public void onOpenClick(ItemImage image) {
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            image.setFullUri(getUriById(image));
            Log.d("uri", "onOpenClick: " + image.getId() + " " + image.gettUri() + " " + image.getFullUri());
            intent.putExtra("str", image.getFullUri().toString());
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
            getAllHdItems();
            uris = getAllItems();
            imageAdapter = new ImageAdapter(uris);
            imageAdapter.setListener(listener);
            recyclerView.setAdapter(imageAdapter);
        }


    }


//    private List<Uri> getAllItems() {
//
//    List<Uri> uris = new ArrayList<Uri>();
//
//        String[] list = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA};
//        Cursor cursor = getContentResolver().query(
//                MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
//                list,
//                null,
//                null,
//                MediaStore.Images.Thumbnails._ID); //Thumbnails - миниатюрные копии
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                String data = cursor.getString(1);
//                Uri imagesUri = Uri.parse(data);
//                uris.add(imagesUri);
//            }
//        }
//        cursor.close();
//
//        return uris;
//    }

    private List<ItemImage> getAllItems() {

        List<ItemImage> uris = new ArrayList<ItemImage>();

        String[] list = {MediaStore.Images.Thumbnails.IMAGE_ID, MediaStore.Images.Thumbnails.DATA};
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
                list,
                null,
                null,
                MediaStore.Images.Thumbnails.IMAGE_ID); //Thumbnails - миниатюрные копии
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String data = cursor.getString(1);
                Uri imagesUri = Uri.parse(data);
                ItemImage ii = new ItemImage();
                Log.d("Uri", "getAllItems: " + id + " " + MediaStore.Images.Thumbnails.IMAGE_ID);
                ii.setId(id);
                ii.settUri(imagesUri);
                uris.add(ii);
            }
            cursor.close();
        }
        return uris;
    }
    private List<ItemImage> getAllHdItems() {

        List<ItemImage> uris = new ArrayList<ItemImage>();

        String[] list = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                list,
                null,
                null,
                MediaStore.Images.Media._ID); //Thumbnails - миниатюрные копии
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String data = cursor.getString(1);
                Uri imagesUri = Uri.parse(data);
                ItemImage ii = new ItemImage();
                Log.d("Uri", "getAllHdItems: " + id + " " + MediaStore.Images.Media._ID);
                ii.setId(id);
                ii.settUri(imagesUri);
                uris.add(ii);
            }
            cursor.close();
        }
        return uris;
    }

    private Uri getUriById(ItemImage itemImage){

        int id = itemImage.getId();
        Uri imagesUri = null;
        String[] list = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                list,
                MediaStore.Images.Media._ID + " = " + id,
                null,
                MediaStore.Images.Media._ID); //Thumbnails - миниатюрные копии
        Log.d("Uri", "getUriById: " + MediaStore.Images.Media._ID + " " + id);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String data = cursor.getString(1);
                imagesUri = Uri.parse(data);
                }
        }
        cursor.close();

        return imagesUri;
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

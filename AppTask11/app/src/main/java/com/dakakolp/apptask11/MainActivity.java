package com.dakakolp.apptask11;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Switch isLoad;
    private Button photo;
    private Button save;
    private Button load;
    private ImageView imageView;

    private Bitmap photoBitmap;

    public static final String MY_PREF = "autoload";
    public static final int CODE_FOR_PHOTO = 108;
    public static final int CODE_FOR_SAVE = 1;
    public static final int CODE_FOR_LOAD = 8;

    private void savePref(boolean isSwitchOn) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(MY_PREF, isSwitchOn);
        edit.apply();
    }

    private void loadPref() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean isSwitchOn = sharedPreferences.getBoolean(MY_PREF, false);
        isLoad.setChecked(isSwitchOn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isLoad = findViewById(R.id.is_load);
        loadPref();

        if (isLoad.isChecked()) {
            loadFile();
        }

        imageView = findViewById(R.id.image_view);
        photo = findViewById(R.id.photo);
        save = findViewById(R.id.save);
        load = findViewById(R.id.load);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, CODE_FOR_PHOTO);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            CODE_FOR_SAVE);
                } else {
                    saveFile();
                }
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            CODE_FOR_LOAD);
                } else {
                    loadFile();
                }

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        boolean isOn = isLoad.isChecked();
        savePref(isOn);
    }

    private void loadFile() {
        String root = Environment.getExternalStorageDirectory().toString();
        File file = new File(root + "/image", "test.jpg");

        try {
            FileInputStream in = new FileInputStream(file);

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inInputShareable = true;
            options.inPurgeable = true;

            Bitmap loadImage = BitmapFactory.decodeFileDescriptor(in.getFD(), null, options);

            if (loadImage != null) imageView.setImageBitmap(loadImage);

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/image");
        myDir.mkdirs();
        File file = new File(myDir, "test.jpg");

        if (file.exists())
            file.delete();

        try {
            FileOutputStream out = new FileOutputStream(file);
            photoBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CODE_FOR_PHOTO:
                if (resultCode == RESULT_OK && data.getExtras() != null) {
                    photoBitmap = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(photoBitmap);
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CODE_FOR_SAVE:
                if (grantResults.length == 1) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        saveFile();
                    }
                }
                break;
            case CODE_FOR_LOAD:
                if (grantResults.length == 1) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        loadFile();
                    }
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

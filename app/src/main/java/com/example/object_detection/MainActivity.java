package com.example.object_detection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.object_detection.helper.ImageHelperActivity;
import com.example.object_detection.image.FlowerIdentificationActivity;
import com.example.object_detection.image.ImageClassificationActivity;

public class MainActivity extends AppCompatActivity {
Button takePermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("SDK Version", "Current version is: " + Build.VERSION.SDK_INT);
        takePermission = findViewById(R.id.permission);
        takePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){
                    if(ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_MEDIA_IMAGES},100);
                    }
                }
//
            }
        });
    }

    public void onGoToImageActivity(View view){
        Intent intent = new Intent(this, ImageClassificationActivity.class);
        startActivity(intent);
    }

    public void onGoToFlowerActivity(View view){
        Intent intent = new Intent(this, FlowerIdentificationActivity.class);
        startActivity(intent);
    }
}
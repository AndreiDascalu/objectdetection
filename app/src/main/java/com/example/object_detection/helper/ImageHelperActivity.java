package com.example.object_detection.helper;

import androidx.annotation.NonNull;
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

import com.example.object_detection.MainActivity;
import com.example.object_detection.R;

public class ImageHelperActivity extends AppCompatActivity {
Button cameraButton;
Button galleryButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_helper);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(ImageHelperActivity.this,new String[]{Manifest.permission.READ_MEDIA_IMAGES},100);
            }
        }

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryHelper();
            }
        });

//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
//                    if(!Environment.isExternalStorageManager()){
//                        try{
//                            Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
//                            intent.addCategory("android.intent.category.DEFAULT");
//                            intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
//                            startActivityIfNeeded(intent,101);
//                        }catch(Exception e){
//                            Intent intent  =new Intent();
//                            intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
//                            startActivityIfNeeded(intent,101);
//                        }
//                    }
//                }
    }

    public void galleryHelper(){
        Intent intent = new Intent();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(ImageHelperActivity.class.getSimpleName(), "grant result for " + permissions[0] + " is " + grantResults[0]);
    }
}
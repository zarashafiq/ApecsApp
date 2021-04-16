package com.example.apecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class PictureOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_options);}



    public void launchdeviceupload (View view){
      Intent intent = new Intent(this, DeviceUpload.class);
      startActivity(intent);
  }

        public void launchfolders (View view){
            Intent intent = new Intent(this, PictureFolders.class);
            startActivity(intent);
        }



    }
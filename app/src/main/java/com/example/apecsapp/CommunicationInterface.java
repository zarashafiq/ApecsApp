package com.example.apecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class CommunicationInterface extends AppCompatActivity {
    ImageView imageView;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coomunication_interface);
        imageView=(ImageView)findViewById(R.id.imageView2);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String resId = bundle.getString("imageuri");
            imageUri =Uri.parse(resId);
            imageView.setImageURI(imageUri);

        }


    }
}
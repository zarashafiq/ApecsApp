package com.example.apecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_option);
    }
        public void launchPictureOptions(View view) {
            Intent intent= new Intent(this,PictureOptions.class);
            startActivity(intent);
        }
    }

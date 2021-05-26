package com.example.apecsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartOption extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_start_option);
        sharedPreferences= getSharedPreferences("myKey", MODE_PRIVATE);





    }
        public void launchPictureOptions(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("level",1);
        editor.apply();
        Intent intent= new Intent(this,PictureOptions.class);
        startActivity(intent);
        int l=sharedPreferences.getInt("level",0);
            Toast.makeText(getApplicationContext(),String.valueOf(l),Toast.LENGTH_LONG).show();



        }
    }

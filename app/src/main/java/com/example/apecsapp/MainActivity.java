package com.example.apecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, StartOption.class);
            startActivity(intent);
            finish();
        }
    }
    public void launchVerificationActivity(View view) {
        Intent intent= new Intent(this,VerificationActivity.class);
        startActivity(intent);
    }
    public void lauchRegistration(View view) {
        Intent intent=new Intent(this,RegistrationActivity.class);
        startActivity(intent);
    }
}
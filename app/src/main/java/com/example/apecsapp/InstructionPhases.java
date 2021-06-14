package com.example.apecsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class InstructionPhases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_phases);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
    public void launchphase1instructions(View view) {

        Intent intent = new Intent(this, Phase1Instructions.class);
        startActivity(intent);
    }
    public void launchphase2instructions(View view) {

        Intent intent = new Intent(this, Phase2Instructions.class);
        startActivity(intent);
    }
    public void launchphase3instructions(View view) {

        Intent intent = new Intent(this, Phase3Instructions.class);
        startActivity(intent);
    }
    public void launchphase4instructions(View view) {

        Intent intent = new Intent(this, Phase4Instructions.class);
        startActivity(intent);
    }
    public void launchphase5instructions(View view) {

        Intent intent = new Intent(this, Phase5Instructions.class);
        startActivity(intent);
    }

}
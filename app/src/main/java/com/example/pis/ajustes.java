package com.example.pis;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import android.widget.ArrayAdapter;

public class ajustes extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Button btnArial = (Button) findViewById(R.id.button);

        btnArial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {


            }
        });

        Button btnNewTimesRoman = (Button) findViewById(R.id.button4);
        btnNewTimesRoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {

            }
        });

        Button btnpequeña = (Button) findViewById(R.id.button5);
        btnpequeña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {

            }
        });

        Button btnmediana = (Button) findViewById(R.id.button6);
        btnmediana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {

            }
        });

        Button btngrande = (Button) findViewById(R.id.button7);
        btngrande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {

            }
        });




        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });









    }
}
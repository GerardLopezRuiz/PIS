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
import android.widget.EditText;
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


    public void setDayNight(){
        SharedPreferences sp = getSharedPreferences("SP", this.MODE_PRIVATE);
        int theme = sp.getInt("Theme",1);
        if(theme==0){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        }

    }
    public static boolean peque=false;
    public static boolean mid= false;
    public static boolean grande = false;



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        setDayNight();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);





        Button btnpequeña = (Button) findViewById(R.id.button5);
        btnpequeña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                peque = true;
                mid = false;
                grande =false;


            }
        });

        Button btnmediana = (Button) findViewById(R.id.button6);
        btnmediana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                peque = false;
                mid =true;
                grande =false;

            }
        });

        Button btngrande = (Button) findViewById(R.id.button7);
        btngrande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                peque = false;
                mid =false;
                grande =true;
            }
        });


        SharedPreferences sp = getSharedPreferences("SP",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Switch switch1 = findViewById(R.id.switch1);
        int theme = sp.getInt("Theme",1);
        if(theme==1){
            switch1.setChecked(false);
        }
        else{
            switch1.setChecked(true);
        }
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch1.isChecked()){
                    editor.putInt("Theme",0);

                }
                else{
                    editor.putInt("Theme",1);

                }
                editor.commit();
                setDayNight();

            }
        });



    }
}
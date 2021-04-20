package com.example.pis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import android.widget.ArrayAdapter;

public class ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] valores = {"Pequeño","Mediano","Grande"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        String[] valores1 = {"Pequeño","Mediano","Grande"};
        spinner1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores1));
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner);
        String[] valores2 = {"Day","Night","Grey"};
        spinner2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores2));
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }
}
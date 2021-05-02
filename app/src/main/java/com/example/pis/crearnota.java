package com.example.pis;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class crearnota extends AppCompatActivity {
    private EditText editTextTitle, editTextDescription;
    private Button finalizar;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearnota);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        editTextTitle = (EditText) findViewById(R.id.Texttitulo);
        editTextDescription = (EditText) findViewById(R.id.Texttexto);
        finalizar = (Button) findViewById(R.id.btnFinalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                if(editTextTitle.getText().toString().length() > 0 || editTextDescription.getText().toString().length() > 0){
                    viewModel.addNotaCard(editTextTitle.getText().toString(),editTextDescription.getText().toString());
                }else{
                    onBackPressed();
                }
            }
            });
    }
}
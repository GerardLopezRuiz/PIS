package com.example.pis;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
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
        viewModel = new MainActivityViewModel();

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
                    if(editTextTitle.getText().toString().length() == 0) {

                        nota nota = new nota("", editTextDescription.getText().toString());
                        viewModel.addNotaCard(nota);
                        Intent intentmain1 = new Intent(a.getContext(), MainActivity.class);
                        startActivityForResult(intentmain1, 0);
                    }else if( editTextDescription.getText().toString().length() == 0){
                        nota nota = new nota(editTextTitle.getText().toString(), "");
                        viewModel.addNotaCard(nota);
                        Intent intentmain2 = new Intent(a.getContext(), MainActivity.class);
                        startActivityForResult(intentmain2, 0);
                    }else{
                        nota nota = new nota(editTextTitle.getText().toString(), editTextDescription.getText().toString());
                        viewModel.addNotaCard(nota);
                        Intent intentmain3 = new Intent(a.getContext(), MainActivity.class);
                        startActivityForResult(intentmain3, 0);
                    }
                }else{
                    onBackPressed();
                }
            }
            });
    }
}
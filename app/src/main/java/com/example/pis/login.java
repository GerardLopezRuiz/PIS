package com.example.pis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

public class login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.btnRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentregister = new Intent (v.getContext(), Register.class);
                startActivityForResult(intentregister, 0);
            }
        });

        Button btn1 = (Button) findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlogin = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intentlogin, 0);
            }
        });



    }
}
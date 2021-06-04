package com.example.pis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class login extends AppCompatActivity {
    String TAG = "Login";
    FirebaseAuth mAuth;
    public static usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        Button btn = (Button) findViewById(R.id.btnRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentregister = new Intent (v.getContext(), Register.class);
                startActivityForResult(intentregister, 0);
            }
        });

        Button btn1 = (Button) findViewById(R.id.btnLogin);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                EditText email = (EditText) findViewById(R.id.emaileditText);
                EditText password = (EditText) findViewById(R.id.txtPass);
                if(email.getText().toString().length() > 0 && password.getText().toString().length() > 0){
                    mAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intentlogin = new Intent (a.getContext(), MainActivity.class);
                                user = new usuario(email.getText().toString(), password.getText().toString());
                                startActivityForResult(intentlogin, 0);
                            } else {
                                // If sign in fails, display a message to the user.
                                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(login.this);
                                final View customLayout = getLayoutInflater().inflate(R.layout.dialog_error, null);
                                alertDialog.setView(customLayout);
                                alertDialog.setPositiveButton("Aceptar",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                                Toast.makeText(getApplicationContext(),"Authentication failed.",Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                alertDialog.show();
                            }
                        }
                    });

                }

            }
        });
    }
}
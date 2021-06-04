package com.example.pis;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomAdapter.ListItemClick {

    private Context parentcontext;
    private MainActivityViewModel viewModel;
    private RecyclerView mRecyclerView;
    public static boolean isUpdate;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentcontext = this;
        password = getIntent().getStringExtra("password");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setLiveDataObservers();

        isUpdate = false;


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcrearnota = new Intent(view.getContext(), crearnota.class);
                startActivityForResult(intentcrearnota, 0);
                setLiveDataObservers();
            }
        });

    }


    @Override
    public void onListItemClick(int clickedItem) {
         nota nota = viewModel.getNotaCard(clickedItem);
         showAlertDialog(nota);


    }

    private void showAlertDialog(final nota note) {
        switch (note.getPasswords()) {
            case "False":
                CharSequence[] options = {"Ver o Modificar", "Ocultar contenido", "Eliminar"};
                defaultAlertDialog(note, options);
                break;
            case "True":
                passwordAlertDialog(note);
                break;
        }
    }
    private void defaultAlertDialog(final nota note, final CharSequence[] options) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Seleccione una opción");
        alertDialogBuilder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (options[i].equals("Ver o Modificar")) {
                    isUpdate = true;
                    Intent intent = new Intent(MainActivity.this, crearnota.class);
                        intent.putExtra("title", note.getTitle());
                        intent.putExtra("text", note.getText());
                        intent.putExtra("password", note.getPasswords());
                        intent.putExtra("id", note.getId());
                    startActivity(intent);
                } else if (options[i].equals("Ocultar contenido")) {
                    note.setPasswords("True");
                    note.saveCard();
                } else if (options[i].equals("Mostrar contenido")) {
                    note.setPasswords("False");
                    note.saveCard();
                } else if (options[i].equals("Eliminar")) {
                    note.deleteCard();
                    setLiveDataObservers();
                }
            }
        });
        alertDialogBuilder.show();
    }

    private void passwordAlertDialog(final nota note) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_password, null);
        alertDialog.setView(customLayout);

        alertDialog.setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editTextPassword = customLayout.findViewById(R.id.editTextPassword);
                         if (login.user.contraseña.equals(editTextPassword.getText().toString())) {
                            CharSequence[] options = {"Ver o Modificar", "Mostrar contenido", "Eliminar"};
                            defaultAlertDialog(note, options);
                        }
                    }
                });

        alertDialog.setNegativeButton("Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_ajustes:
                Intent intentajustes = new Intent(this, ajustes.class);
                startActivityForResult(intentajustes, 0);
                return true;


            case R.id.action_Cerrarsesion:
                FirebaseAuth.getInstance().signOut();
                Intent intentlogin = new Intent(this, login.class);
                startActivityForResult(intentlogin, 0);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
    public void setLiveDataObservers() {
        //Subscribe the activity to the observable
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        final Observer<ArrayList<nota>> observer = new Observer<ArrayList<nota>>() {
            @Override
            public void onChanged(ArrayList<nota> nota) {
                CustomAdapter newAdapter = new CustomAdapter(parentcontext, nota, (CustomAdapter.ListItemClick) parentcontext);
                mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(parentcontext));
                mRecyclerView.setAdapter(newAdapter);
                newAdapter.notifyDataSetChanged();
            }
        };

        final Observer<String> observerToast = new Observer<String>() {
            @Override
            public void onChanged(String t) {
                Toast.makeText(parentcontext, t, Toast.LENGTH_SHORT).show();
            }
        };

        viewModel.getNotaCards().observe(this, observer);
        viewModel.getToast().observe(this, observerToast);

    }


}
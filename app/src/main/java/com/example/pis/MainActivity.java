package com.example.pis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.RequiresApi;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context parentcontext;
    private MainActivityViewModel viewModel;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentcontext = this.getBaseContext();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        setLiveDataObservers();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcrearnota = new Intent(view.getContext(), crearnota.class);
                startActivityForResult(intentcrearnota, 0);
            }
        });

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

            case R.id.action_ordenar:
                Intent intentordenar = new Intent(this, Ordenar.class);
                startActivityForResult(intentordenar, 0);

                return true;
            case R.id.action_archivados:
                Intent intentarchivados = new Intent(this, archivados.class);
                startActivityForResult(intentarchivados, 0);
                return true;

            case R.id.action_Cerrarsesion:
                FirebaseAuth.getInstance().signOut();
                onBackPressed();
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
            public void onChanged(ArrayList<nota> ac) {
                CustomAdapter newAdapter = new CustomAdapter(parentcontext, ac);
                mRecyclerView.swapAdapter(newAdapter, false);
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
        viewModel.getToast().observe(this, observerToast);;

    }




}
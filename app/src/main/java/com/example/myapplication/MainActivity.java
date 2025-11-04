package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MyRVAdapter.ItemClickListener{
    Vehiculo[] v = ArrayVehiculos.getVehiculos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView rc= findViewById(R.id.recyclerView);

        rc.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rc.setLayoutManager(layoutManager);

        // Asociamos un adapter (ver más adelante cómo definirlo)
        MyRVAdapter mAdapter = new MyRVAdapter(MainActivity.this, v);
        rc.setAdapter(mAdapter);


    }


   @Override
    public void onRVItemClick(View view, int position) {
    }
}
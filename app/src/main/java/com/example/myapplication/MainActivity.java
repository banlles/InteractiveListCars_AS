package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MyRVAdapter.OnItemClickListener {
    Car[] c = ArrayCars.getVehiculos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView rc = findViewById(R.id.recyclerView);

        rc.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rc.setLayoutManager(layoutManager);

        // Asociamos un adapter (ver más adelante cómo definirlo)
        MyRVAdapter mAdapter = new MyRVAdapter(MainActivity.this, c, this);
        rc.setAdapter(mAdapter);


    }

    public void onItemClick(int position) {
        Intent i = new Intent(MainActivity.this, InfoShowCar.class);
        i.putExtra("car", c[position]);
        activityLauncher.launch(i);
    }


    private final ActivityResultLauncher<Intent> activityLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    int codigo = result.getData().getIntExtra("codigo", -1);
                    switch (codigo) {
                        case 1:
                            break;
                    }
                }
            });

}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRVAdapter.OnItemClickListener {
    ArrayList<Car> allCars = ArrayListCars.getVehiculos(); // Lista de coches
    ArrayList<Car> visibleCars; // Lista de coches

    RecyclerView rc; // Vista de lista
    MyRVAdapter mAdapter; // Adaptador para el RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Inicializa la actividad
        setContentView(R.layout.activity_main); // Carga el diseño

        rc = findViewById(R.id.recyclerViewCars); // Enlaza el RecyclerView del XML
        rc.setHasFixedSize(true); // Optimiza rendimiento
        rc.setLayoutManager(new LinearLayoutManager(getApplicationContext())); // Lista vertical

        visibleCars = allCars;
        createList(visibleCars); // Muestra todos los coches
    }

    // Al hacer clic en un coche abre la info detallada
    public void onItemClick(int position) {
        Intent i = new Intent(MainActivity.this, InfoShowCar.class);
        i.putExtra("car", visibleCars.get(position));
        activityLauncher.launch(i);
    }

    // Filtra los coches según el tipo de motor seleccionado en el menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ArrayList<Car> filteredCars = new ArrayList<>();
        String tipoMotor;
        int id = item.getItemId();

        if (id == R.id.OpcionGasolina) {
            tipoMotor = "Gasolina";
            for (Car c : allCars)
                if (c.getTipoMotor().equals(tipoMotor))
                    filteredCars.add(c);
        } else if (id == R.id.OpcionDiesel) {
            tipoMotor = "Diésel";
            for (Car c : allCars)
                if (c.getTipoMotor().equals(tipoMotor))
                    filteredCars.add(c);
        } else if (id == R.id.OpcionMostrarTodos)
                    filteredCars = allCars;
        else
            return super.onOptionsItemSelected(item);

        visibleCars = filteredCars;
        createList(visibleCars); // Actualiza la lista mostrada
        return true;
    }

    // Crea el adaptador y lo asigna al RecyclerView
    public void createList(ArrayList<Car> c) {
        mAdapter = new MyRVAdapter(MainActivity.this, c, this);
        rc.setAdapter(mAdapter);
    }

    // Carga el menú en la barra superior
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.car_menu, menu);
        return true;
    }

    // Recibe resultados al volver de otra actividad
    private final ActivityResultLauncher<Intent> activityLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    int codigo = result.getData().getIntExtra("codigo", -1);
                    if (codigo == 1) {
                        // acción opcional
                    }
                }
            });
}

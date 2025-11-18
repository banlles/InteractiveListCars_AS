package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InfoShowCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_show_car);

        Car car = getIntent().getParcelableExtra("car");
        if (car == null) return;

        TextView marca = findViewById(R.id.ShowInfoMarca);
        TextView modelo = findViewById(R.id.ShowInfoModelo);
        TextView tipoMotor = findViewById(R.id.ShowInfoITipoMotor);
        TextView potencia = findViewById(R.id.ShowInfoPotencia);
        TextView puertas = findViewById(R.id.ShowInfoPuertas);
        TextView transmision = findViewById(R.id.ShowInfoTransmision);
        ImageView imagen = findViewById(R.id.ShowInfoImage);
        Button btnAbrirWeb = findViewById(R.id.btnAbrirWeb);
        Button btnCompartir = findViewById(R.id.btnCompartir);


        marca.setText(car.getMarca());
        modelo.setText(car.getModelo());
        tipoMotor.setText(car.getTipoMotor());
        potencia.setText(String.valueOf(car.getPotencia()));
        puertas.setText(String.valueOf(car.getPuertas()));
        transmision.setText(car.getTransmision());
        imagen.setImageResource(car.getImagen());

        //Intent explicito abrir web
        btnAbrirWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(car.getUrl()));
            startActivity(intent);
        });

        //Intent generico compartir
        btnCompartir.setOnClickListener(v -> {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Mira este coche de Mercedes que he visto:\n" + car.getUrl());
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, "Compartir con...");
            startActivity(shareIntent);
        });

    }
}

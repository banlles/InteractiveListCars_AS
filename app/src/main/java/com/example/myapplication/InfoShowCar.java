package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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

        marca.setText(car.getMarca());
        modelo.setText(car.getModelo());
        tipoMotor.setText(car.getTipoMotor());
        potencia.setText(String.valueOf(car.getPotencia()));
        puertas.setText(String.valueOf(car.getPuertas()));
        transmision.setText(car.getTransmision());
        imagen.setImageResource(car.getImagen());
    }
}

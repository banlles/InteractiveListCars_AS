package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private TextView tv, tvAciertos, tvFallos;
    private ImageView img;
    EditText et;

    private ArrayList<Car> allCars;
    private int indice = 0;
    private int aciertos = 0;
    private int fallos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv = findViewById(R.id.textViewPregunta);
        img = findViewById(R.id.imageViewCoche);
        et = findViewById(R.id.editTextRespuesta);
        tvAciertos = findViewById(R.id.textViewAciertos);
        tvFallos = findViewById(R.id.textViewFallos);

        Button btnResponder = findViewById(R.id.btnComprobarRespuesta);

        allCars = getIntent().getParcelableArrayListExtra("carList");

        mostrarPregunta();
        actualizarMarcadores();

        btnResponder.setOnClickListener(v -> comprobarRespuesta());
    }

    private void mostrarPregunta() {
        if (indice < allCars.size()) {
            Car car = allCars.get(indice);
            img.setImageResource(car.getImagen());
            tv.setText("Pregunta: ¿Qué modelo de coche es este?");
            et.setText("");
        } else {
            tv.setText("Juego terminado.\nAciertos: " + aciertos + "\nFallos: " + fallos);
        }
    }

    private void comprobarRespuesta() {
        if (indice >= allCars.size()) return;

        Car car = allCars.get(indice);
        String respuesta = et.getText().toString().trim();

        if (respuesta.equalsIgnoreCase(car.getModelo())) {
            tv.setText("¡Correcto!");
            aciertos++;
        } else {
            tv.setText("Incorrecto. La respuesta correcta es " + car.getModelo());
            fallos++;
        }

        indice++;
        actualizarMarcadores();
        mostrarPregunta();
    }

    private void actualizarMarcadores() {
        tvAciertos.setText("Aciertos: " + aciertos);
        tvFallos.setText("Fallos: " + fallos);
    }
}

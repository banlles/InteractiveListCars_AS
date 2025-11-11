package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListCars {

    private static ArrayList<Car> vehiculos = new ArrayList<>(Arrays.asList(
            new Car("Mercedes", "A180", "Gasolina", 136, 5, "Manual", R.drawable.mercedes_a180),
            new Car("Mercedes", "C200", "Gasolina", 204, 4, "Automatica", R.drawable.mercedes_c200),
            new Car("Mercedes", "E220d", "Diesel", 200, 4, "Automatica", R.drawable.mercedes_e220),
            new Car("Mercedes", "GLA 250", "Gasolina", 224, 5, "Automatica", R.drawable.mercedes_gla250),
            new Car("Mercedes", "GLE 350d", "Diesel", 272, 5, "Automatica", R.drawable.mercedes_gle350)));


    public static ArrayList<Car> getVehiculos() {
        return vehiculos;
    }
}

package com.example.myapplication;

public class ArrayCars {

    private static Car[] vehiculos = {
            new Car("Mercedes", "A180", "Gasolina", 136, 5, "Manual", R.drawable.mercedes_a180),
            new Car("Mercedes", "C200", "Gasolina", 204, 4, "Automática", R.drawable.mercedes_c200),
            new Car("Mercedes", "E220d", "Diésel", 200, 4, "Automática", R.drawable.mercedes_e220),
            new Car("Mercedes", "GLA 250", "Gasolina", 224, 5, "Automática", R.drawable.mercedes_gla250),
            new Car("Mercedes", "GLE 350d", "Híbrido Diésel", 272, 5, "Automática", R.drawable.mercedes_gle350)
    };

    public static Car[] getVehiculos() {
        return vehiculos;
    }
}

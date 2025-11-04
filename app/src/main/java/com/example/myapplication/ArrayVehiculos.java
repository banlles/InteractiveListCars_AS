package com.example.myapplication;

public class ArrayVehiculos {

    private static Vehiculo[] vehiculos = {
            new Vehiculo("Mercedes", "A180", "Gasolina", 136, 5, "Manual", R.drawable.mercedes_a180),
            new Vehiculo("Mercedes", "C200", "Gasolina", 204, 4, "Automática", R.drawable.mercedes_c200),
            new Vehiculo("Mercedes", "E220d", "Diésel", 200, 4, "Automática", R.drawable.mercedes_e220),
            new Vehiculo("Mercedes", "GLA 250", "Gasolina", 224, 5, "Automática", R.drawable.mercedes_gla250),
            new Vehiculo("Mercedes", "GLE 350d", "Híbrido Diésel", 272, 5, "Automática", R.drawable.mercedes_gle350)
    };

    public static Vehiculo[] getVehiculos() {
        return vehiculos;
    }
}

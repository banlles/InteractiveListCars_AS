package com.example.myapplication;

public class Vehiculo {
    String marca;
    String color;
    String puertas;

    public Vehiculo(String marca, String color, String puertas) {
        this.marca = marca;
        this.color = color;
        this.puertas = puertas;
    }

    public Vehiculo() {

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPuertas() {
        return puertas;
    }

    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }
}

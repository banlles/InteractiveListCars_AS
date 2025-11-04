package com.example.myapplication;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String tipoMotor;   // Ej: "Gasolina", "Diesel", "Eléctrico"
    private int potencia;       // en caballos (CV)
    private int puertas;        // número de puertas
    private String transmision; // Ej: "Manual" o "Automática"
    private int imagen;

    public Vehiculo(String marca, String modelo, String tipoMotor,
                    int potencia, int puertas, String transmision, int imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.potencia = potencia;
        this.puertas = puertas;
        this.transmision = transmision;
        this.imagen = imagen;
    }

    public Vehiculo() {}

    // Getters y setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getTipoMotor() { return tipoMotor; }
    public void setTipoMotor(String tipoMotor) { this.tipoMotor = tipoMotor; }

    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }

    public int getPuertas() { return puertas; }
    public void setPuertas(int puertas) { this.puertas = puertas; }

    public String getTransmision() { return transmision; }
    public void setTransmision(String transmision) { this.transmision = transmision; }

    public int getImagen() { return imagen; }
    public void setImagen(int imagen) { this.imagen = imagen; }
}

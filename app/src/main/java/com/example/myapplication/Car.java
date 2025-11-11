package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private String marca;
    private String modelo;
    private String tipoMotor;   // Ej: "Gasolina", "Diesel", "Eléctrico"
    private int potencia;       // en caballos (CV)
    private int puertas;        // número de puertas
    private String transmision; // Ej: "Manual" o "Automática"
    private int imagen;         // recurso drawable

    public Car(String marca, String modelo, String tipoMotor,
               int potencia, int puertas, String transmision, int imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.potencia = potencia;
        this.puertas = puertas;
        this.transmision = transmision;
        this.imagen = imagen;
    }

    // Constructor vacío (por si lo necesitas)
    public Car() {
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    // ------------------------------------------------------------
    // ----------- IMPLEMENTACIÓN DE PARCELABLE -------------------
    // ------------------------------------------------------------

    // Constructor usado al "desempaquetar" el objeto
    protected Car(Parcel in) {
        marca = in.readString();
        modelo = in.readString();
        tipoMotor = in.readString();
        potencia = in.readInt();
        puertas = in.readInt();
        transmision = in.readString();
        imagen = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeString(modelo);
        dest.writeString(tipoMotor);
        dest.writeInt(potencia);
        dest.writeInt(puertas);
        dest.writeString(transmision);
        dest.writeInt(imagen);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}

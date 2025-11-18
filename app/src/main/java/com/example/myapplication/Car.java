package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {

    private String marca;
    private String modelo;
    private String tipoMotor;
    private int potencia;
    private int puertas;
    private String transmision;
    private int imagen;
    private String url; // 👈 aquí guardamos la web

    public Car(String marca, String modelo, String tipoMotor, int potencia, int puertas,
               String transmision, int imagen, String url) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.potencia = potencia;
        this.puertas = puertas;
        this.transmision = transmision;
        this.imagen = imagen;
        this.url = url;
    }

    // Constructor para reconstruir desde Parcel
    protected Car(Parcel in) {
        marca = in.readString();
        modelo = in.readString();
        tipoMotor = in.readString();
        potencia = in.readInt();
        puertas = in.readInt();
        transmision = in.readString();
        imagen = in.readInt();
        url = in.readString();
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
        dest.writeString(url);
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

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getPuertas() {
        return puertas;
    }

    public String getTransmision() {
        return transmision;
    }

    public int getImagen() {
        return imagen;
    }

    public String getUrl() {
        return url;
    }
}

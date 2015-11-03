package com.salesianostriana.dam.di.recycleview;

/**
 * Created by miguelcampos on 28/10/15.
 */
public class ItemViaje {
    private String ciudad;
    private String pais;
    private int imagen;
    private int puntuacion;

    public ItemViaje(String ciudad, String pais, int imagen, int puntuacion) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.imagen = imagen;
        this.puntuacion = puntuacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}

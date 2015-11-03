package com.salesianostriana.dam.di.myapplication;

/**
 * Created by miguelcampos on 30/10/15.
 */
public class ItemCiudad {

    private int imagen;
    private String nombre;

    public ItemCiudad(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

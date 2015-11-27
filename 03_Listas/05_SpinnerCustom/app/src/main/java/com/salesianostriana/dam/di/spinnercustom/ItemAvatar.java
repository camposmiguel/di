package com.salesianostriana.dam.di.spinnercustom;

/**
 * Created by miguelcampos on 27/11/15.
 */
public class ItemAvatar {
    private String nombre;
    private int id;

    public ItemAvatar(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

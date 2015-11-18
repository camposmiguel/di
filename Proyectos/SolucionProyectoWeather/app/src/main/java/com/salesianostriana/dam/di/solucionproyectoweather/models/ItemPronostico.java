package com.salesianostriana.dam.di.solucionproyectoweather.models;

/**
 * Created by miguelcampos on 17/11/15.
 */
public class ItemPronostico {
    private int icon;
    private int temperatura;
    private String dia;

    public ItemPronostico(String dia, int icon, int temperatura) {

        this.dia = dia;
        this.icon = icon;
        this.temperatura = temperatura;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

}

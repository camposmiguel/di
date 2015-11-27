package com.salesianostriana.dam.di.spinnercustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by miguelcampos on 27/11/15.
 */
public class AvatarSpinnerAdapter extends ArrayAdapter<ItemAvatar> {
    Context contexto;
    ArrayList<ItemAvatar> avatares;
    int layout;


    public AvatarSpinnerAdapter(Context context, int resource, ArrayList<ItemAvatar> objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.avatares = objects;
        this.layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutDesplegableAvatar = inflater.inflate(layout, parent, false);

        ItemAvatar avatarActual = avatares.get(position);

        TextView nombre = (TextView)layoutDesplegableAvatar.findViewById(R.id.textViewNombreAvatar);
        ImageView imagen = (ImageView)layoutDesplegableAvatar.findViewById(R.id.imageViewAvatar);

        nombre.setText(avatarActual.getNombre());
        Picasso.with(contexto).load("http://rest.miguelcr.com/images/aroundme/" + String.valueOf(avatarActual.getId()) + ".png").into(imagen);

        return layoutDesplegableAvatar;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutDesplegableAvatar = inflater.inflate(layout, parent, false);

        ItemAvatar avatarActual = avatares.get(position);

        TextView nombre = (TextView)layoutDesplegableAvatar.findViewById(R.id.textViewNombreAvatar);
        ImageView imagen = (ImageView)layoutDesplegableAvatar.findViewById(R.id.imageViewAvatar);

        nombre.setText(avatarActual.getNombre());
        Picasso.with(contexto).load("http://rest.miguelcr.com/images/aroundme/" + String.valueOf(avatarActual.getId()) + ".png").into(imagen);

        return layoutDesplegableAvatar;
    }
}

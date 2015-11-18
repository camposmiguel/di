package com.salesianostriana.dam.di.solucionproyectoweather.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.salesianostriana.dam.di.solucionproyectoweather.R;
import com.salesianostriana.dam.di.solucionproyectoweather.services.GcmRegistrationAsyncTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiempoActualFragment extends Fragment {

    public ImageView iconWeather;
    public TextView textViewTemperatura;
    public TextView textViewCiudad;

    // Elementos formulario registro GCM para notificaciones
    public EditText nombreCiudad;
    public Button btnRegisterGcm;


    public TiempoActualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tiempo_actual, container, false);

        // Rescato los elementos de la IU
        iconWeather = (ImageView)v.findViewById(R.id.imageView);
        textViewTemperatura = (TextView)v.findViewById(R.id.textViewTemperatura);
        textViewCiudad = (TextView)v.findViewById(R.id.nombreCiudad);

        nombreCiudad = (EditText)v.findViewById(R.id.editTextNombreCiudad);
        btnRegisterGcm = (Button)v.findViewById(R.id.buttonRegisterGcm);

        // Modifico los elementos de la IU
        iconWeather.setImageResource(R.drawable.ic_rain);
        textViewCiudad.setText("New York");
        textViewTemperatura.setText("10º");

        btnRegisterGcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GcmRegistrationAsyncTask(getActivity()).execute(nombreCiudad.getText().toString());
            }
        });

        return v;
    }


}

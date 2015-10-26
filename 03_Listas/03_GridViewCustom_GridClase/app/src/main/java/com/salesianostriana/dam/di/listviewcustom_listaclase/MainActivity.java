package com.salesianostriana.dam.di.listviewcustom_listaclase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (GridView)findViewById(R.id.gridView);

        final ArrayList<Alumno> listadoAlumnos = new ArrayList<Alumno>();
        listadoAlumnos.add(new Alumno("Pepe","Vaina",611556688, true));
        listadoAlumnos.add(new Alumno("María","Perez",611556688, false));
        listadoAlumnos.add(new Alumno("Armando","Jaleo",611556688, true));
        listadoAlumnos.add(new Alumno("Benito","Cármela sdkfhsdkadskjdhas kjdh",611556688, false));
        listadoAlumnos.add(new Alumno("Armando","Jaleo",611556688, true));
        listadoAlumnos.add(new Alumno("Armando","Jaleo",611556688, true));
        listadoAlumnos.add(new Alumno("Armando","Jaleo",611556688, true));

        final AlumnoAdapter adaptador = new AlumnoAdapter(this,listadoAlumnos);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Alumno alumnoSeleccionado = listadoAlumnos.get(position);

                if(alumnoSeleccionado.isPagado()) {
                    alumnoSeleccionado.setPagado(false);
                } else  {
                    alumnoSeleccionado.setPagado(true);
                }

                adaptador.notifyDataSetChanged();
            }
        });

    }
}

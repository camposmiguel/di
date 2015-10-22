package com.salesianostriana.dam.di.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner desplegableDiasSemana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desplegableDiasSemana = (Spinner) findViewById(R.id.weeksdays_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weekdays_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        desplegableDiasSemana.setAdapter(adapter);

        // Asociamos el Spinner al evento OnItemSelectedListener
        desplegableDiasSemana.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // El siguiente método nos devolvería el nombre del día seleccionado.
        String diaSeleccionado = (String)desplegableDiasSemana.getSelectedItem();

        // Obtenemos el nombre del día seleccionado a partir del parámetro "position"
        String[] arrayDiasSemana = getResources().getStringArray(R.array.weekdays_array);
        Toast.makeText(this,"Se ha seleccionado: "+arrayDiasSemana[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

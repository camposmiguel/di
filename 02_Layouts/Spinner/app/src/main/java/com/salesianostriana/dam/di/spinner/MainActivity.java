package com.salesianostriana.dam.di.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner desplegableDiasSemana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desplegableDiasSemana = (Spinner) findViewById(R.id.weeksdays_spinner);

        
    }
}

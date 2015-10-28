package com.salesianostriana.dam.di.listactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alumnos = new String[] {"Carlos","Diego","Luis","Jesús","Fernando","Carlos","Diego","Luis","Jesús","Fernando"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alumnos);

        setListAdapter(adaptador);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(MainActivity.this, "Seleccionado: " + alumnos[position], Toast.LENGTH_SHORT).show();

        v.animate().setDuration(1000).rotationX(360);
    }
}

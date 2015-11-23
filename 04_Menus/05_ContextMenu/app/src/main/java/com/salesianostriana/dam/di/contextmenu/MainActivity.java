package com.salesianostriana.dam.di.contextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] alumnos;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.listView);
        alumnos = new String[] {"Carlos","Diego","Luis","Jesús","Fernando","Carlos","Diego","Luis","Jesús","Fernando"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alumnos);

        lista.setAdapter(adaptador);

        // La siguiente línea de código conecta el evento LongClick sobre un elemento
        // del ListView, con el Menú Contextual
        registerForContextMenu(lista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        AdapterView.AdapterContextMenuInfo info;
        try {
            // Casts the incoming data object into the type for AdapterView objects.
            info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {
            // If the menu object can't be cast, logs an error.
            Log.e("TAG", "bad menuInfo", e);
            return;
        }

        String alumnoSeleccionado = alumnos[info.position];


        menu.setHeaderTitle(alumnoSeleccionado);
        menu.setHeaderIcon(android.R.drawable.stat_notify_sdcard);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String alumnoSeleccionado = alumnos[info.position];
        switch (item.getItemId()) {
            case R.id.cm_action_edit:
                // Lanzar Toast con alumno a editar
                return true;
            case R.id.cm_action_share:
                // Lanzar un Intent implícito
                // que permita compartir por Whatsapp
                // el nombre del alumno seleccionado
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}

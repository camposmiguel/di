package com.salesianostriana.dam.di.listviewstring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    String[] alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.listView);
        alumnos = new String[] {"Carlos","Diego","Luis","Jesús","Fernando","Carlos","Diego","Luis","Jesús","Fernando"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alumnos);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Seleccionado: "+alumnos[position],Toast.LENGTH_SHORT).show();

                view.animate().setDuration(1000).rotationX(360);
            }
        });

    }
}

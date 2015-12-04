package com.salesianostriana.menucontextualactionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    String[] alumnos;
    boolean[] seleccionados;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemViaje> viajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // Si tenemos claro que el layout que hemos utilizado
        // para pintar un elemento de la lista, no varía de dimensiones
        // es recomendable poner la siguiente línea de código, que
        // permite al recycler saber que las dimensiones no cambian
        // y por tanto se ahorra el tener que hacer cálculos a la
        // hora de reutilizar las vistas
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        viajes = new ArrayList();
        viajes.add(new ItemViaje("Sevilla","Spain",R.drawable.giralda,5));
        viajes.add(new ItemViaje("Madrid","Spain",R.drawable.giralda,5));
        viajes.add(new ItemViaje("Barcelona","Spain",R.drawable.giralda,4));
        viajes.add(new ItemViaje("Valencia","Spain",R.drawable.giralda,5));
        viajes.add(new ItemViaje("Cádiz","Spain",R.drawable.giralda,1));
        viajes.add(new ItemViaje("Granada","Spain",R.drawable.giralda,3));
        viajes.add(new ItemViaje("Santiago","Spain",R.drawable.giralda,2));

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(viajes);
        mRecyclerView.setAdapter(mAdapter);

        // Transformamos la lista en un elemento de selección múltiple
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        // Asociar al ListView un Menú CAB (Contextual Action Bar)
        lista.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            Menu menuActual;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB

                seleccionados[position] = checked;
                mode.setTitle(String.valueOf(getNumSeleccionados()));

                MenuItem infoItem = menuActual.findItem(R.id.info_item);
                if(getNumSeleccionados()>1) {
                    infoItem.setVisible(false);
                } else {
                    infoItem.setVisible(true);
                }

            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.delete_items:
                        Toast.makeText(MainActivity.this,"Eliminar seleccionados",Toast.LENGTH_LONG).show();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context, menu);
                menuActual = menu;
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
                seleccionados = new boolean[alumnos.length];
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                Log.i("Menu","Menu Prepare");

                return false;
            }
        });
    }

    public int getNumSeleccionados() {
        int contador = 0;
        for(int i=0; i<seleccionados.length; i++) {
            if(seleccionados[i]) {
                contador++;
            }
        }
        return contador;
    }
}

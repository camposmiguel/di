package com.salesianostriana.dam.di.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
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

    }
}

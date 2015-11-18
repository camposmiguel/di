package com.salesianostriana.dam.di.solucionproyectoweather.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.dam.di.solucionproyectoweather.R;
import com.salesianostriana.dam.di.solucionproyectoweather.adapters.PronosticoAdapter;
import com.salesianostriana.dam.di.solucionproyectoweather.models.ItemPronostico;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PronosticoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemPronostico> pronosticos;



    public PronosticoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pronostico, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        // Si tenemos claro que el layout que hemos utilizado
        // para pintar un elemento de la lista, no varía de dimensiones
        // es recomendable poner la siguiente línea de código, que
        // permite al recycler saber que las dimensiones no cambian
        // y por tanto se ahorra el tener que hacer cálculos a la
        // hora de reutilizar las vistas
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        pronosticos = new ArrayList();
        pronosticos.add(new ItemPronostico("Lunes", R.drawable.ic_rain,10));
        pronosticos.add(new ItemPronostico("Martes", R.drawable.ic_rain,20));
        pronosticos.add(new ItemPronostico("Miércoles", R.drawable.ic_rain,14));
        pronosticos.add(new ItemPronostico("Jueves", R.drawable.ic_rain,12));
        pronosticos.add(new ItemPronostico("Viernes", R.drawable.ic_rain,15));

        // specify an adapter (see also next example)
        mAdapter = new PronosticoAdapter(pronosticos);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }


}

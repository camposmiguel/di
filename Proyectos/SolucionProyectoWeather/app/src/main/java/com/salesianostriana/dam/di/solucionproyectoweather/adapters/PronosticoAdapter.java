package com.salesianostriana.dam.di.solucionproyectoweather.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salesianostriana.dam.di.solucionproyectoweather.R;
import com.salesianostriana.dam.di.solucionproyectoweather.models.ItemPronostico;

import java.util.ArrayList;

/**
 * Created by miguelcampos on 17/11/15.
 */

    public class PronosticoAdapter extends RecyclerView.Adapter<PronosticoAdapter.PronosticoViewHolder> {
        private ArrayList<ItemPronostico> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class PronosticoViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView dia;
            public TextView temperatura;
            public ImageView icon;
            public PronosticoViewHolder(View v) {

                super(v);

                dia = (TextView)v.findViewById(R.id.textViewDiaSemana);
                temperatura = (TextView)v.findViewById(R.id.textViewTemperatura);
                icon = (ImageView)v.findViewById(R.id.imageViewIcon);

            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public PronosticoAdapter(ArrayList<ItemPronostico> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public PronosticoAdapter.PronosticoViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_pronostico, parent, false);
            // set the view's size, margins, paddings and layout parameters

            PronosticoViewHolder vh = new PronosticoViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(PronosticoViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.dia.setText(mDataset.get(position).getDia());
            holder.temperatura.setText(mDataset.get(position).getTemperatura() + "º");
            holder.icon.setImageResource(mDataset.get(position).getIcon());
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }


package com.salesianostriana.menucontextualactionbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by miguelcampos on 28/10/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViajeViewHolder> {
    private ArrayList<ItemViaje> mDataset;
    private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();
    Context ctx;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViajeViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView puntuacionTextView;
        public ImageView imagenCiudad;
        public ViajeViewHolder(View v) {

            super(v);

            puntuacionTextView = (TextView) v.findViewById(R.id.puntuacion);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            imagenCiudad = (ImageView) v.findViewById(R.id.imagen_ciudad);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<ItemViaje> myDataset, Context context) {
        mDataset = myDataset;
        ctx = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViajeViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_viaje, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViajeViewHolder vh = new ViajeViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViajeViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getCiudad());
        holder.puntuacionTextView.setText(String.valueOf(mDataset.get(position).getPuntuacion()));

        if (mSelection.get(position) != null) {
            holder.imagenCiudad.setImageResource(R.drawable.check);
        } else {
            holder.imagenCiudad.setImageResource(mDataset.get(position).getImagen());
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // MÉTODOS DE LA SELECCIÓN MÚLTIPLE

    public void setNewSelection(int position, boolean value) {
        mSelection.put(position, value);
        notifyDataSetChanged();
    }

    public boolean isPositionChecked(int position) {
        Boolean result = mSelection.get(position);
        return result == null ? false : result;
    }

    public Set<Integer> getCurrentCheckedPosition() {
        return mSelection.keySet();
    }

    public void removeSelection(int position) {
        mSelection.remove(position);
        notifyDataSetChanged();
    }

    public void clearSelection() {
        mSelection = new HashMap<Integer, Boolean>();
        notifyDataSetChanged();
    }
}
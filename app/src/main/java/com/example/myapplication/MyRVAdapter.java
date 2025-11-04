package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyViewHolder> {
    Vehiculo[] vehiculos;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // La actividad que contenga el RecyclerViewer va a tener que implementar esta interfaz
    // para recibir los clicks en los items de nuestro recycler view.
    public interface ItemClickListener {
        void onRVItemClick(View view, int position);
    }

    // El Activity que incluya el Recycler View que utilice este adapter llamará a este metodo para indicar que es el listener.
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // Se llamara desde el ItemClickListener implementado en la Actividad contenedora
    public Vehiculo getItem(int position) {
        return vehiculos[position];
    }

    // Constructor, los datos los recibimos en el constructor.
    public MyRVAdapter(Context context, Vehiculo[] vehiculos) {
        super();
        this.mInflater = LayoutInflater.from(context);
        this.vehiculos = vehiculos;
    }

    // ----------METODOS QUE HAY QUE SOBRECARGAR DE LA CLASE RecyclerView.Adapter<> ----------
    // inflates the row layout from xml when needed
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_text_view, parent, false);
        return new MyViewHolder(view);
    }

    // Binds (vincula) los datos al Textview para cada item
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Vehiculo v = vehiculos[position];
        holder.img.setImageResource(v.getImagen());
        holder.marca.setText(v.getMarca());
        holder.modelo.setText(v.getModelo());
    }

    // Número total de items
    @Override
    public int getItemCount() {
        return vehiculos.length;
    }

    // ---------------------------------------------------------------------------------------
    // --------- IMPLEMENTACION DE NUESTRO VIEW HOLDER ESPECÍFICO ----------------------------
    // stores and recycles views as they are scrolled off screen
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView marca, modelo;
        ImageView img;

        MyViewHolder(View itemView) {
            //Lligar els Id dels elements que vull mostrar per pantalla per cada un dels elements de Dades
            super(itemView);
            img = itemView.findViewById(R.id.imagenViewVehiculo);
            modelo = itemView.findViewById(R.id.textViewModelo);
            marca = itemView.findViewById(R.id.textViewMarca);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onRVItemClick(view, getAdapterPosition());
        }
    }
}